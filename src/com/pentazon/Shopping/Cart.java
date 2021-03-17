package com.pentazon.Shopping;

import com.pentazon.Payments.PaymentCard;
import com.pentazon.Product.Product;
import com.pentazon.Product.ProductService;
import com.pentazon.Product.ProductServiceImpl;
import com.pentazon.exceptions.ProductExceptions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.logging.Logger;

public class Cart {
    private Logger logger = Logger.getLogger(Cart.class.getName());
    private Map<String, Item> items;
    private ProductService productService;
    private BigDecimal total = BigDecimal.ZERO;
    private PaymentCard paymentCard;

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }

    public Cart() {
        items = new HashMap<>();
        productService = new ProductServiceImpl();

    }

    public void addToCart(Product product) {
        if (verifiedProduct(product)) {
            Item item = items.get(product.getProductId());
            if (item == null) {
                item = new Item(product);

            }
            item.addItems(BigInteger.ONE.intValue());
            this.items.put(product.getProductId(), item);
        }

    }

    public void addToCart(Product product, int quantity) {
        if (verifiedProduct(product)) {
            Item item = items.get(product.getProductId());
            if (item == null) {
                item = new Item(product);
            }
            item.addItems(quantity);
            this.items.put(product.getProductId(), item);
        }

    }

    public boolean verifiedProduct(Product product){
        boolean verified = false;
        if(product != null){
            try{
                Product verifiedProduct = productService.findProductById(product.getProductId());
                verified = true;
            }catch (ProductExceptions ignored){

            }
        }return verified;
    }

    public boolean removeFromCart(Product product){
        boolean removed = false;
        if(product != null){
            this.items.remove(product.getProductId());
            removed = true;
        }
        return removed;
    }

    public BigDecimal calculateCartTotal() {
        if(!items.isEmpty()){
            this.total = BigDecimal.ZERO;
            Iterator<Item> cartItems = items.values().iterator();
            while(cartItems.hasNext()){
                System.out.println(this.total.toString());
                this.total = this.total.add(cartItems.next().getTotal());

            }
        }
        return this.getTotal();
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}