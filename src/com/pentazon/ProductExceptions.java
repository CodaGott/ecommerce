package com.pentazon;

public class ProductExceptions extends Exception{

    public ProductExceptions() {
    }

    public ProductExceptions(String message) {
        super(message);
    }

    public ProductExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductExceptions(Throwable cause) {
        super(cause);
    }

}
