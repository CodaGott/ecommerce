package com.pentazon.Shopping;

import com.pentazon.Product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class Order {
    private Map<String, Item> orderItems;
    private BigDecimal orderTotal;
    private LocalDate deliveryDate;
    private LocalDate orderDate;
}
