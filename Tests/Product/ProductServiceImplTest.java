package Product;

import com.pentazon.Product.Product;
import com.pentazon.Product.ProductService;
import com.pentazon.Product.ProductServiceImpl;
import com.pentazon.exceptions.ProductExceptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    ProductService productService;
    Product product;
    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl() ;
        product = new Product("TestProduct ", "Product for testing", new BigDecimal(50));
        product.setProductId("Test101");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findProduct(){
        Product product = null;
        try {
            product = productService.findProductById("AD001");
        } catch (ProductExceptions productExceptions) {
            productExceptions.printStackTrace();
        }
        assertNotNull(product);

    }

    @Test
    void findProductWithInvalidID(){
//        com.pentazon.Product product = null;
//        try {
//            product = productService.findProductById("AD001");
//        } catch (ProductExceptions productExceptions) {
//            productExceptions.printStackTrace();
//        }
        assertThrows(ProductExceptions.class,()->productService.findProductById("DUD008"));


    }

    @Test
    void addNullProduct(){
        product.setName(" ");
        assertThrows(ProductExceptions.class,()-> productService.addProduct(product));
    }

    @Test
    void addNullPrice(){
        product.setPrice(new BigDecimal(50));
        assertThrows(ProductExceptions.class,()-> productService.addProduct(product));

    }@Test
    void addProduct(){
        Map<String, Product> initialProduct = productService.getAllProducts();
        assertTrue(initialProduct.size() ==3);
        try {
            Map<String, Product> allProducts = productService.getAllProducts();
            boolean result = productService.addProduct(product);
            assertTrue(result);
            assertTrue(allProducts.size() ==4);

            Product check = productService.findProductById("Test101");
            assertNotNull(check);
        }catch (ProductExceptions e){
            e.printStackTrace();
        }
    }

    @Test
    void removeNullProduct(){
        assertThrows(ProductExceptions.class,()-> productService.addProduct(product));
    }



}