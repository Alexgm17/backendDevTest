package org.alejandrogm.service.rest;

import java.util.List;

/**
 * @author agallegomorilla
 *
 */
public interface ProductRestClient {
    List<String> createRequestSimilarProductsIds(String productId);
}
