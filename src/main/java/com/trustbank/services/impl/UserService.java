package com.trustbank.services.impl;

import com.trustbank.dto.LoginRequest;
import com.trustbank.dto.Response;
import com.trustbank.dto.UserDTO;
import com.trustbank.enums.USER_ROLE;
import com.trustbank.exception.OurException;
import com.trustbank.model.Customer;
import com.trustbank.model.User;
import com.trustbank.repository.UserRepository;
import com.trustbank.services.CustomUserDetailsService;
import com.trustbank.services.interfac.IUserService;
import com.trustbank.utils.JWTUtils;
import com.trustbank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Response registerUser(User user) {
        Response response = new Response();
        try{
            if(user.getRole() == null || user.getRole().isBlank()){
                user.setRole(String.valueOf(USER_ROLE.CUSTOMER));
            }

            if(userRepository.existsByUsername(user.getUsername())){
                throw new OurException(String.format("%s Already Exists",user.getUsername()));
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userRepository.save(user);
            UserDTO userDTO = Utils.mapUserEntityToUserDTO(savedUser);

            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setUser(userDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred During User Registration %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response login(LoginRequest loginRequest) {
        Response response = new Response();
        UserDetails userDetails = new CustomUserDetailsService().loadUserByUsername(loginRequest.getUsername());
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword(),userDetails.getAuthorities()));
            var user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(()-> new OurException("User not found"));

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            USER_ROLE role = USER_ROLE.valueOf(authorities.isEmpty()?null:authorities.iterator().next().getAuthority());

            var jwt = jwtUtils.generateToken(user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRole(String.valueOf(role));
            response.setExpirationDate("20 minutes");
            response.setMessage("Successful");
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred During Login %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAllUsers() {
        Response response = new Response();
        try{
            List<User> userList = userRepository.findAll();
            List<UserDTO> userDTOList = Utils.mapUserListEntityToUserListDTO(userList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setUserList(userDTOList);

        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Users %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response deleteUser(String username) {
        Response response = new Response();

        try{
            User user = userRepository.findByUsername(username).orElseThrow(() -> new OurException("User not Found"));
            userRepository.deleteById(user.getId());
            response.setStatusCode(200);
            response.setMessage("Successful");
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Deleting User %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getMyInfo(String username) {
        Response response = new Response();

        try{
            User user = userRepository.findByUsername(username).orElseThrow(() -> new OurException("User not Found"));
            UserDTO userDTO = Utils.mapUserEntityToUserDTO(user);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setUser(userDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Retrieving User Info %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getUserByCustomer(Customer customer) {
        return null;
    }
}
