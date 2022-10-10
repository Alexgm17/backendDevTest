package org.alejandrogm.products.service.dto.output;

import java.io.Serializable;
import java.util.Set;

public class SimilarProductsDetailsODTO implements Serializable {
    private Set<ProductDetailODTO> productDetailODTOS;

    public SimilarProductsDetailsODTO (Set<ProductDetailODTO> productDetailODTOS) {
        this.productDetailODTOS = productDetailODTOS;
    }

    public SimilarProductsDetailsODTO () {
    }

    public Set<ProductDetailODTO> getProductDetailODTOS () {
        return productDetailODTOS;
    }

    public void setProductDetailODTOS (Set<ProductDetailODTO> productDetailODTOS) {
        this.productDetailODTOS = productDetailODTOS;
    }
}
