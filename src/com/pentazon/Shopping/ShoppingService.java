package com.pentazon.Shopping;

import com.pentazon.customer.Buyer;
import com.pentazon.customer.Customer;
import com.pentazon.exceptions.CheckOutException;

public interface ShoppingService {

    public boolean checkOut(Buyer customer) throws CheckOutException;
}
