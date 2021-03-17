package com.pentazon.customer;

import com.pentazon.Payments.PaymentCard;
import com.pentazon.Shopping.Cart;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Customer{
    private List<PaymentCard> card;
    private Cart cart;

    public Buyer() {
        card = new ArrayList<>();
        cart = new Cart();
    }

    public List<PaymentCard> getCard() {
        return card;
    }

    public void setCard(List<PaymentCard> card){
        this.card = card;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCards(Cart cart) {
        this.cart = cart;
    }
}
