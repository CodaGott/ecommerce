package com.pentazon.Product;

import com.pentazon.exceptions.ProductExceptions;

import java.util.Map;

/**
 * provides services for dealing with products in pentazon
 */
public interface ProductService {

    /**
     * search for product with specified id
     * @param productId
     * @return product with specified Id
     */

    /**
     *
     * @param productId
     * @return
     * @throws ProductExceptions
     */
    public Product findProductById(String productId) throws ProductExceptions;

    public Map<String, Product> getAllProducts();

    /**
     *
     * @param product
     * @return
     * @throws ProductExceptions
     */
    public boolean addProduct(Product product) throws ProductExceptions;

    /**
     *
     * @param product
     * @return
     * @throws ProductExceptions
     */
    public boolean removeProduct(Product product) throws ProductExceptions;
}
