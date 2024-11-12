package com.trustbank.utils;

import lombok.NoArgsConstructor;

import java.util.Random;


@NoArgsConstructor
public class Generators {

    public String generateBankVerificationNumber(){
        StringBuilder bankVerificationNumber = new StringBuilder();
        bankVerificationNumber.append("232");
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int digit = random.nextInt(10); // Generates a random integer from 0 to 9
            bankVerificationNumber.append(digit);
        }
        return String.valueOf(bankVerificationNumber);
    }


    public String generateAccountNumber(){
        StringBuilder accountNumber= new StringBuilder();
        accountNumber.append("201");
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            int digit = random.nextInt(10); // Generates a random integer from 0 to 9
            accountNumber.append(digit);
        }
        return String.valueOf(accountNumber);
    }

    public String generateCardNumber(){
        StringBuilder cardNumber= new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10); // Generates a random integer from 0 to 9
            cardNumber.append(digit);
        }
        return String.valueOf(cardNumber);
    }

    public String generateCVV(){
        StringBuilder cvv = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int digit = random.nextInt(10); // Generates a random integer from 0 to 9
            cvv.append(digit);
        }
        return String.valueOf(cvv);
    }
}
