package com.pentazon.Product;

import com.pentazon.ProductExceptions;

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
