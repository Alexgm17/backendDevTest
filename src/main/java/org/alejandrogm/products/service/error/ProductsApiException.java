package org.alejandrogm.products.service.error;

public class ProductsApiException {
    private final String message;

    public String getMessage () {
        return message;
    }

    public ProductsApiException (String message) {
        this.message = message;
    }
}
