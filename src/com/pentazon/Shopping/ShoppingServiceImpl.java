package com.pentazon.Shopping;

import com.pentazon.Payments.PaymentService;
import com.pentazon.Payments.Paystack;
import com.pentazon.customer.Buyer;
import com.pentazon.customer.Customer;
import com.pentazon.exceptions.CheckOutException;

import java.time.LocalDate;

public class ShoppingServiceImpl implements ShoppingService{

    private PaymentService paymentService;

    public ShoppingServiceImpl(){
        paymentService = new Paystack();
    }

    @Override
    public Order checkOut(Buyer buyer) throws CheckOutException {
        this.isValidCheckout(buyer);
        Cart buyerCart = buyer.getCart();
        boolean result = paymentService.pay(buyer.getCart().getPaymentCard(), buyerCart.getTotal());


        Order order = new Order();
        order.setOrderItems(buyer.getCart().getItems());

        if (result) {
            order.setOrderItems(buyer.getCart().getItems());
            order.setPaid(result);
            order.setOrderDate(LocalDate.now());
            order.setOrderTotal(buyerCart.getTotal());
            order.setDeliveryAddress(buyerCart.getDeliveryAddress());
            buyer.setCart(null);
        }
        buyer.setCart(null);

        return order;
    }

    private boolean isValidCheckout(Buyer buyer) throws CheckOutException{
        if(buyer == null){
            // Todo log error
            throw new CheckOutException("No buyer found");
        }
        if (buyer.getCart() == null){
            // Todo log error
            throw new CheckOutException("No cart found at check out");
        }

        if (buyer.getCart().getItems().isEmpty()){
            // Todo log error
            throw new CheckOutException("Cart is empty at check out");
        }

        if (buyer.getCard() == null || buyer.getCard().isEmpty()){
            //Todo log error
            throw new CheckOutException("No card provided at check out");
        }

        if(buyer.getCart().getPaymentCard() == null){
            //Todo log error
            throw new CheckOutException("No payment card found at check out");
        }

        return true;
    }
}
