package com.pentazon.Product;

import com.pentazon.exceptions.ProductExceptions;

public class ProductServiceImpl implements ProductService{

    private ProductDataBase productRepo = new ProductDataBase();

    /**
     *
     * @param productId
     * @return
     */
    @Override
    public Product findProductById(String productId) throws ProductExceptions {
        return productRepo.getProductById(productId);
    }
}
