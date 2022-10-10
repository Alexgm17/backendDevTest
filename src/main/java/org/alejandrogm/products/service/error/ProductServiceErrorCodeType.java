package org.alejandrogm.products.service.error;

public enum ProductServiceErrorCodeType {

    PRODUCT_NOT_FOUND(404, "Product Not found."),
    PRODUCT_OK(200, "Product found");
    private final int code;
    private final String description;

    private ProductServiceErrorCodeType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
