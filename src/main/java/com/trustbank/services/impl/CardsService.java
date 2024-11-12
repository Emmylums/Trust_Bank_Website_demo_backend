package com.trustbank.services.impl;

import com.trustbank.enums.CARD_TYPE;
import com.trustbank.dto.CardsDTO;
import com.trustbank.dto.Response;
import com.trustbank.exception.OurException;
import com.trustbank.model.Cards;
import com.trustbank.model.Customer;
import com.trustbank.repository.CardsRepository;
import com.trustbank.services.interfac.ICardsService;
import com.trustbank.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardsService implements ICardsService {

    @Autowired
    private CardsRepository cardsRepository;

    @Override
    public Response addCards(Cards cards) {
        Response response = new Response();
        try{
            if(cardsRepository.existsByCardNumber(cards.getCardNumber())){
                throw new OurException(String.format("Card %s Already Exists",cards.getCardNumber()));
            }
            Cards savedCards = cardsRepository.save(cards);
            CardsDTO cardsDTO = Utils.mapCardsEntityToCardsDTO(savedCards);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCards(cardsDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred During Card Registration %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getAllCards() {
        Response response = new Response();
        try{
            List<Cards> cards = cardsRepository.findAll();
            List<CardsDTO> cardsDTOList = Utils.mapCardsListEntityToCardsListDTO(cards);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCardsList(cardsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Cards %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsByCardNumber(String cardNumber) {
        Response response = new Response();
        try{
            Cards cards = cardsRepository.findByCardNumber(cardNumber).orElseThrow(() -> new OurException("Card Not found"));
            CardsDTO cardsDTO = Utils.mapCardsEntityToCardsDTO(cards);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCards(cardsDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Card %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsById(String id) {
        Response response = new Response();
        try{
            Cards cards = cardsRepository.findById(Long.valueOf(id)).orElseThrow(() -> new OurException("Card Not found"));
            CardsDTO cardsDTO = Utils.mapCardsEntityToCardsDTO(cards);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCards(cardsDTO);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Card %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsByActivationPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        Response response = new Response();
        try{
            List<Cards> cardsList = cardsRepository.findCardsByActivationPeriod(startDate, endDate).orElseThrow(() -> new OurException("Cards Not found"));
            List<CardsDTO> cardsDTOList = Utils.mapCardsListEntityToCardsListDTO(cardsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCardsList(cardsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Cards %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsByExpirationPeriod(LocalDateTime startDate, LocalDateTime endDate) {
        Response response = new Response();
        try{
            List<Cards> cardsList = cardsRepository.findCardsByExpirationPeriod(startDate, endDate).orElseThrow(() -> new OurException("Cards Not found"));
            List<CardsDTO> cardsDTOList = Utils.mapCardsListEntityToCardsListDTO(cardsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCardsList(cardsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Cards %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsByActivationDate(LocalDateTime activationDate) {
        Response response = new Response();
        try{
            List<Cards> cardsList = cardsRepository.findByActivationDate(activationDate).orElseThrow(() -> new OurException("Cards Not found"));
            List<CardsDTO> cardsDTOList = Utils.mapCardsListEntityToCardsListDTO(cardsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCardsList(cardsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Cards %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsByExpirationDate(LocalDateTime expirationDate) {
        Response response = new Response();
        try{
            List<Cards> cardsList = cardsRepository.findByExpirationDate(expirationDate).orElseThrow(() -> new OurException("Cards Not found"));
            List<CardsDTO> cardsDTOList = Utils.mapCardsListEntityToCardsListDTO(cardsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCardsList(cardsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Cards %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsByCardType(CARD_TYPE cardType) {
        Response response = new Response();
        try{
            List<Cards> cardsList = cardsRepository.findByCardType(String.valueOf(cardType)).orElseThrow(() -> new OurException("Cards Not found"));
            List<CardsDTO> cardsDTOList = Utils.mapCardsListEntityToCardsListDTO(cardsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCardsList(cardsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Cards %s",e.getMessage()));
        }
        return response;
    }

    @Override
    public Response getCardsByCustomer(Customer customer) {
        Response response = new Response();
        try{
            List<Cards> cardsList = cardsRepository.findByCustomer(customer).orElseThrow(() -> new OurException("Cards Not found"));
            List<CardsDTO> cardsDTOList = Utils.mapCardsListEntityToCardsListDTO(cardsList);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setCardsList(cardsDTOList);
        }catch (OurException e){
            response.setStatusCode(400);
            response.setMessage(e.getMessage());
        }
        catch (Exception e){
            response.setStatusCode(500);
            response.setMessage(String.format("Error Occurred While Retrieving Cards %s",e.getMessage()));
        }
        return response;
    }
}
