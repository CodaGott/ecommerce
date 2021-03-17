package com.pentazon.exceptions;

public class ProductExceptions extends PentazonException{


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
