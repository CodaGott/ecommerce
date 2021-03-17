package Product;

import com.pentazon.Product.Product;
import com.pentazon.Product.ProductService;
import com.pentazon.Product.ProductServiceImpl;
import com.pentazon.ProductExceptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceImplTest {

    ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductServiceImpl() ;

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

}