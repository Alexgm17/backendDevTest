package org.alejandrogm.service.impl;

import jakarta.inject.Inject;
import org.alejandrogm.service.ProductsService;
import org.alejandrogm.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.service.rest.ProductRestClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductsService {

    @Inject
    ProductRestClient productRestClient;
    private final Logger log = Logger.getLogger(ProductsService.class.getName());
    @Override
    public SimilarProductsDetailsODTO getSimilarProductsDetails (String productId) {
        log.info("INIT ProductServiceImpl.getSimilarProductsDetails");
        // Get similar products ids calling to WS
        List<String> similarProductsIdsRes = productRestClient.createRequestSimilarProductsIds(productId);
        log.info("END ProductServiceImpl.getSimilarProductsDetails");
        return null;
    }
}
