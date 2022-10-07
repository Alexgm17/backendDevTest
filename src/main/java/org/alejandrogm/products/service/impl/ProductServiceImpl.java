package org.alejandrogm.products.service.impl;

import org.alejandrogm.products.service.ProductsService;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.products.service.rest.ProductRestClient;
import org.alejandrogm.products.service.transformer.ProductsControllerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductsService {

    @Autowired
    private ProductsControllerTransformer productsControllerTransformer;

    private final Logger log = Logger.getLogger(ProductsService.class.getName());
    @Override
    public SimilarProductsDetailsODTO getSimilarProductsDetails (String productId) {
        log.info("INIT ProductServiceImpl.getSimilarProductsDetails");
        // Get similar products ids calling to WS
        var similarProductsDetailsODTO = new SimilarProductsDetailsODTO();
        var productDetailODTOS = new HashSet<ProductDetailODTO>();
        List<String> similarProductsIdsRes = ProductRestClient.createRequestSimilarProductsIds(productId);
        similarProductsIdsRes.parallelStream().forEach(id ->
                productDetailODTOS.add(ProductRestClient.createRequestGetProductDetails(id)));
        similarProductsDetailsODTO.setProductDetailODTOS(productDetailODTOS);
        log.info("END ProductServiceImpl.getSimilarProductsDetails");
        return similarProductsDetailsODTO;
    }
}
