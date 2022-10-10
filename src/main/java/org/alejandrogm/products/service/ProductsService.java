package org.alejandrogm.products.service;

import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;

public interface ProductsService {

    /**
     * @param productId
     * @return SimilarProductsDetailsODTO
     */
    public SimilarProductsDetailsODTO getSimilarProductsDetails(String productId);
}
