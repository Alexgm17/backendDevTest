package org.alejandrogm.products.service;

import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;

/**
 * @author agallegomorilla
 *
 */
public interface ProductsService {

    /**
     * @param productId
     * @return SimilarProductsDetailsODTO
     */
    public SimilarProductsDetailsODTO getSimilarProductsDetails(String productId);
}
