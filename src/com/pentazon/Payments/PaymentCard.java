package com.pentazon.Payments;

import java.time.LocalDate;
import java.util.Date;

public class PaymentCard {
    private String cardNumber;
    private String name;
    private LocalDate expiryDate;
    private Date issueDate;


    public PaymentCard(String cardNumber, String name, LocalDate expiryDate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
