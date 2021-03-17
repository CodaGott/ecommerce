package com.pentazon.Shopping;

import com.pentazon.Payments.PaymentCard;
import com.pentazon.Product.ProductDataBase;
import com.pentazon.customer.Buyer;
import com.pentazon.customer.Customer;
import com.pentazon.exceptions.CheckOutException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

class ShoppingServiceImplTest {

    private Buyer donDozie;
    private ShoppingService shoppingService;

    @BeforeEach
    void setUp() {
        shoppingService = new ShoppingServiceImpl();
        ProductDataBase products = new ProductDataBase();
        donDozie = new Buyer();
        PaymentCard fbnVisa = new PaymentCard("12345677", "Don Dozie", LocalDate.of(2025, 6, 1));
        donDozie.getCard().add(fbnVisa);
        Cart dozieCart = new Cart();
        dozieCart.addToCart(products.getMockProducts().get("AD001"), 5);

        donDozie.setCart(dozieCart);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkOutWithNullBuyer(){
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(null));
    }

    @Test
    void checkOutWithNullCart(){
        donDozie.setCart(null);
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(null));
    }


    @Test
    void checkOutWithEmptyCart(){
        donDozie.setCart(new Cart());
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(null));
    }

    @Test
    void checkOutWithNullPaymentCart(){
        donDozie.setCard(null);
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(null));
    }

    @Test
    void checkOutWithNoPaymentCart(){
        donDozie.setCard(Collections.emptyList());
        assertThrows(CheckOutException.class, () -> shoppingService.checkOut(null));
    }

    @Test
    void checkOut(){

    }
}