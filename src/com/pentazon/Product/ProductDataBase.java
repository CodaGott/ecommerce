package com.pentazon.Product;

import com.pentazon.exceptions.ProductExceptions;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductDataBase {
    private Map<String,Product> mockProducts;

    public ProductDataBase(){
        mockProducts = new HashMap<>();
        Product plantainChips = new Product( "Adunni chips", "Savour plantain Chips",new BigDecimal(12));
        plantainChips.setProductId("AD001");
        mockProducts.put(plantainChips.getProductId(), plantainChips);


        Product noseMasks = new Product();
        noseMasks.setProductId("AD002");
        noseMasks.setName("Bomu e nose mask");
        noseMasks.setDescription("Best in class nose masks");
        noseMasks.setPrice(new BigDecimal(4500));
        mockProducts.put(noseMasks.getProductId(), noseMasks);


        Product shirt = new Product("vintage shirt", "Vintage versace shirt", new BigDecimal(5000));
        shirt.setProductId("AD003");
        mockProducts.put(shirt.getProductId(),shirt);

    }

    public Map<String, Product> getMockProducts(){
        return mockProducts;
    }

    public  void  setMockProducts(Map<String, Product> mockProducts){
        this.mockProducts = mockProducts;
    }

    public Product getProductById(String Id) throws ProductExceptions {
        Product result = mockProducts.get(Id);
        if(result == null){
            StringBuilder message = new StringBuilder("com.pentazon.Product with Id");
            message.append(Id);
            message.append("not found");
            throw new ProductExceptions(message.toString());
        }

        return result;
    }

}
