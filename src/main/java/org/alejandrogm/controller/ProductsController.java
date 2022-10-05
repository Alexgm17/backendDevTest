package org.alejandrogm.controller;

import com.alejandrogm.backenddevtest.openapi.api.ProductApi;
import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import jakarta.inject.Inject;
import org.alejandrogm.service.ProductsService;
import org.alejandrogm.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.controller.transformer.ProductsControllerTransformer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Controller for product requests
 *
 * @author agallegomorilla
 */
@RestController
public class ProductsController implements ProductApi {

    private final Logger log = Logger.getLogger(ProductApi.class.getName());
    @Inject
    private ProductsService productsService;

    @Inject
    private ProductsControllerTransformer productsControllerTransformer;

    @Override
    public ResponseEntity<Set<ProductDetail>> getProductSimilar (String productId) {
        LocalDateTime tini = LocalDateTime.now();
        log.info(String.format("INIT GET /product/{productId}/similar with %s", productId));
        SimilarProductsDetailsODTO similarProductsDetailsODTO = productsService.getSimilarProductsDetails(productId);
        Set<ProductDetail> listSimilarProductsDetails = productsControllerTransformer.toListSimilarProductsDetails(similarProductsDetailsODTO);
        log.info(String.format("END GET /product/{productId}/similar with %s. Response time: %d", productId, (ChronoUnit.MILLIS.between(tini, LocalDateTime.now()))));
        return new ResponseEntity<>(listSimilarProductsDetails, HttpStatus.OK);
    }
}

