package com.pentazon.Product;

import com.pentazon.exceptions.ProductExceptions;

import java.util.Map;

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

    @Override
    public Map<String, Product> getAllProducts() {
        return productRepo.getMockProducts();
    }

    /**
     * @param product
     * @return
     * @throws ProductExceptions
     */
    @Override
    public boolean addProduct(Product product) throws ProductExceptions {
        this.isValidProduct(product);
        productRepo.getMockProducts().put(product.getProductId(), product);
        return true;
    }

    /**
     * @param product
     * @return
     * @throws ProductExceptions
     */
    @Override
    public boolean removeProduct(Product product) throws ProductExceptions {
        if(product == null){
            throw new ProductExceptions("Cannot remove null product");
        }
        return false;
    }

    private boolean isValidProduct(Product product) throws  ProductExceptions {
        boolean result = false;
        if (product == null) {
            throw new ProductExceptions("Can not add null product");
        }
        if (product.getName() == null || product.getName().equals("")) {
            throw new ProductExceptions("Product name is required");
        }

        if (product.getPrice() == null) {
            throw new ProductExceptions("Product name is required");
        }

        return true;
    }
}
