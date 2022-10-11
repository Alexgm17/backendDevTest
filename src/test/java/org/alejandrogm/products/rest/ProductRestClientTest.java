package org.alejandrogm.products.rest;

import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.alejandrogm.products.service.error.CustomApiException;
import org.alejandrogm.products.service.rest.ProductRestClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ProductRestClientTest {

    @Mock
    ProductRestClient productRestClient;

    @Test
    public void testCreateRequestSimilarProductsIdsOK() {
        List<String> similarIds = Arrays.asList("100", "1000", "10000");
        List<String> similarIdsExpected = productRestClient.createRequestSimilarProductsIds("3");
        assertEquals(similarIds, similarIdsExpected);
    }

    @Test
    public void testCreateRequestSimilarProductsIdsKO() {
        Exception exception = assertThrows(CustomApiException.class, () -> productRestClient.createRequestSimilarProductsIds("6"));
        assertEquals(CustomApiException.class, exception.getClass());
        assertEquals(exception.getMessage(), "Product Not found.");
    }

    @Test
    public void testCreateRequestGetProductDetailsOK() {
        var price = new BigDecimal(9.99);
        var priceRounded = price.setScale(2, RoundingMode.HALF_EVEN);
        var product1 = new ProductDetailODTO("1", "Shirt", priceRounded, true);
        ProductDetailODTO productExpected = productRestClient.createRequestGetProductDetails("1");
        assertEquals(product1.getName(), productExpected.getName());
        assertEquals(product1.getPrice(), productExpected.getPrice());
    }

    @Test
    public void testCreateRequestGetProductDetailsNull() {
        ProductDetailODTO productExpected = productRestClient.createRequestGetProductDetails("8");
        assertEquals(null, productExpected);
    }
}
