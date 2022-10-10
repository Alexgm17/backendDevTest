package org.alejandrogm.products.service.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler (CustomApiException.class)
    @ResponseStatus (HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleCustomException(CustomApiException e) {
        ProductsApiException productsApiException = new ProductsApiException(ProductServiceErrorCodeType.PRODUCT_NOT_FOUND.getDescription());
        return new ResponseEntity<>(productsApiException, HttpStatus.NOT_FOUND);
    }

}