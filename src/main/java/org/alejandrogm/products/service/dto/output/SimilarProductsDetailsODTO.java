package org.alejandrogm.products.service.dto.output;

import java.util.Set;

/**
 * @author agallegomorilla
 *
 */
public class SimilarProductsDetailsODTO  {
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
