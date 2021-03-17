package com.pentazon.Shopping;

import com.pentazon.Payments.PaymentService;
import com.pentazon.Payments.Paystack;
import com.pentazon.customer.Buyer;
import com.pentazon.customer.Customer;
import com.pentazon.exceptions.CheckOutException;

public class ShoppingServiceImpl implements ShoppingService{

    private PaymentService paymentService;

    public ShoppingServiceImpl(){
        paymentService = new Paystack();
    }

    @Override
    public boolean checkOut(Buyer buyer) throws CheckOutException {
        if(this.isValidCheckout(buyer));
        return false;
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
