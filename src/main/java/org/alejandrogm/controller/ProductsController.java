package org.alejandrogm.controller;

import com.alejandrogm.backenddevtest.openapi.api.ProductApi;
import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.alejandrogm.service.dto.output.SimilarProductsDetailsODTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * Controller for product requests
 *
 * @author agallegomorilla
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductsController implements ProductApi {

    @Override
    public ResponseEntity<Set<ProductDetail>> getProductSimilar (String productId) {
        LocalDateTime tini = LocalDateTime.now();
        log.info("INIT GET /product/{productId}/similar with {}", productId);
        SimilarProductsDetailsODTO similarProductsDetailsODTO;
        Set<ProductDetail> listSimilarProductsDetails = null;
        log.info("END GET /product/{productId}/similar with {}", productId, (ChronoUnit.MILLIS.between(tini, LocalDateTime.now())));
        return new ResponseEntity<>(listSimilarProductsDetails, HttpStatus.OK);
    }
}

