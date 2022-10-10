package org.alejandrogm.products.controller;

import com.alejandrogm.backenddevtest.openapi.api.ProductApi;
import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.ProductsService;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.products.service.transformer.ProductsTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Controller for product requests
 */
@RestController
public class ProductsController implements ProductApi {

    private final Logger log = Logger.getLogger(ProductApi.class.getName());
    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductsTransformer productsTransformer;

    @Override
    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<Set<ProductDetail>> getProductSimilar (@PathVariable String productId) {
        LocalDateTime tini = LocalDateTime.now();
        log.info(String.format("INIT GET /product/{productId}/similar with %s", productId));
        SimilarProductsDetailsODTO similarProductsDetailsODTO = productsService.getSimilarProductsDetails(productId);
        Set<ProductDetail> listSimilarProductsDetails = productsTransformer.toListSimilarProductsDetails(similarProductsDetailsODTO);
        log.info(String.format("END GET /product/{productId}/similar with %s. Response time: %d", productId, (ChronoUnit.MILLIS.between(tini, LocalDateTime.now()))));
        return new ResponseEntity<>(listSimilarProductsDetails, HttpStatus.OK);
    }
}

