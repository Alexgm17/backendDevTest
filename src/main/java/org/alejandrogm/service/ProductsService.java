package org.alejandrogm.service;

import org.alejandrogm.service.dto.output.SimilarProductsDetailsODTO;

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
