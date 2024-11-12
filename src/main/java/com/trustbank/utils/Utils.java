package com.trustbank.utils;

import com.trustbank.dto.*;
import com.trustbank.enums.ADMIN_ROLE;
import com.trustbank.enums.CARD_TYPE;
import com.trustbank.enums.TRANSACTION_TYPE;
import com.trustbank.enums.USER_ROLE;
import com.trustbank.model.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private static final String ALPHANUMBERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final SecureRandom secureRandom = new SecureRandom();


    public static String generateRandomAlphanumeric(int length){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++){
            int randomIndex = secureRandom.nextInt(ALPHANUMBERIC_STRING.length());
            char randomChar = ALPHANUMBERIC_STRING.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }

    public static UserDTO mapUserEntityToUserDTO(User user){
        return new UserDTO(user.getId(), user.getUsername(), USER_ROLE.valueOf(user.getRole()), user.getCustomer(), user.getAdmin());
    }

    public static AdminDTO mapAdminEntityToAdminDTO(Admin admin){
        return new AdminDTO(admin.getId(), admin.getTitle(), admin.getFirstName(), admin.getMiddleName(), admin.getLastName(), admin.getEmail(), admin.getPhoneNumber(), ADMIN_ROLE.valueOf(admin.getAdminRole()), admin.getAddress(), admin.getVerificationImages());
    }

    public static CustomerDTO mapCustomerEntityToCustomerDTO(Customer customer){
        return new CustomerDTO(customer.getId(), customer.getAccountNumber(), customer.getFirstName(), customer.getMiddleName(), customer.getLastName(), customer.getMaritalStatus(), customer.getGender(),customer.getDateOfBirth(), customer.getLocalGovernmentArea(),customer.getStateOfOrigin(),customer.getNationality(), customer.getEmail(), customer.getPhoneNumber(), customer.getAddress(), customer.getBankVerificationNumber(), customer.getVerificationImages(), customer.getBalance(), customer.getAccountCondition(), customer.getTransactions());
    }

    public static TransactionsDTO mapTransactionsEntityToTransactionsDTO(Transactions transactions){
        return new TransactionsDTO(transactions.getId(), transactions.getAmount(), transactions.getTransactionDate(), TRANSACTION_TYPE.valueOf(transactions.getTransactionType()), transactions.getReceiver(), transactions.getSender());
    }

    public static CardsDTO mapCardsEntityToCardsDTO(Cards card){
        return new CardsDTO(card.getId(), CARD_TYPE.valueOf(card.getCardType()), card.getCardNumber(), card.getCVV(), card.getActivationDate(), card.getExpirationDate(), card.getCustomer());
    }

    public static AddressDTO mapAddressEntityToAddressDTO(Address address){
        return new AddressDTO(address.getId(), address.getHouseDetails(), address.getStreet(), address.getLocalGovernmentArea(), address.getState(), address.getNation(), address.getCustomer(), address.getAdmin());
    }

    public static ImageDTO mapImageEntityToImageDTO(Image image){
        return new ImageDTO(image.getId(), image.getImageName(), image.getImageData(), image.getCustomer(), image.getAdmin());
    }

    public static List<UserDTO> mapUserListEntityToUserListDTO(List<User> userList){
        return userList.stream().map(Utils::mapUserEntityToUserDTO).collect(Collectors.toList());
    }

    public static List<AdminDTO> mapAdminListEntityToAdminListDTO(List<Admin> adminList){
        return adminList.stream().map(Utils::mapAdminEntityToAdminDTO).collect(Collectors.toList());
    }

    public static List<CustomerDTO> mapCustomerListEntityToCustomerListDTO(List<Customer> customerList){
        return customerList.stream().map(Utils::mapCustomerEntityToCustomerDTO).collect(Collectors.toList());
    }

    public static List<TransactionsDTO> mapTransactionsListEntityToTransactionsListDTO(List<Transactions> transactionsList){
        return transactionsList.stream().map(Utils::mapTransactionsEntityToTransactionsDTO).collect(Collectors.toList());
    }

    public static List<CardsDTO> mapCardsListEntityToCardsListDTO(List<Cards> cardsList){
        return cardsList.stream().map(Utils::mapCardsEntityToCardsDTO).collect(Collectors.toList());
    }

    public static List<AddressDTO> mapAddressListEntityToAddressListDTO(List<Address> addressList){
        return addressList.stream().map(Utils::mapAddressEntityToAddressDTO).collect(Collectors.toList());
    }

    public static List<ImageDTO> mapImageListEntityToImageListDTO(List<Image> imageList){
        return imageList.stream().map(Utils::mapImageEntityToImageDTO).collect(Collectors.toList());
    }
}
