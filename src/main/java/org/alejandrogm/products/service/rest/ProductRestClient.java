package org.alejandrogm.products.service.rest;

import com.alejandrogm.backenddevtest.openapi.api.ProductApi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.alejandrogm.products.service.error.CustomApiException;
import org.alejandrogm.products.service.error.ProductServiceErrorCodeType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class ProductRestClient {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static final Logger log = Logger.getLogger(ProductApi.class.getName());

    @Inject
    private Environment env;

    @Value("${server.port}")
    private static String URL_GETSIMILARPRODUCTS;

    public static List<String> createRequestSimilarProductsIds (String productId) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:3001/product/"+productId+"/similarids"))
                .setHeader("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            log.info(String.format("Calling external service for obtain similar products with id: %s", productId));
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();

            if (ProductServiceErrorCodeType.PRODUCT_OK.getCode()==response.statusCode()) {
                List<String> similarProductsIds = mapper.readValue(response.body(), new TypeReference<List<>>() {});
                return similarProductsIds;
            } else if (ProductServiceErrorCodeType.PRODUCT_NOT_FOUND.getCode()==response.statusCode()) {
                log.info(String.format("Error calling external service for obtain similar products with id: %s", productId));
                throw new CustomApiException(ProductServiceErrorCodeType.PRODUCT_NOT_FOUND.getDescription());
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (RuntimeException r) {
            log.info(String.format("Error calling external service for obtain similar products with id: %s", productId));
            throw new CustomApiException(ProductServiceErrorCodeType.PRODUCT_NOT_FOUND.getDescription());
        }
        return null;
    }

    public static ProductDetailODTO createRequestGetProductDetails (String productId) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:3001/product/"+productId))
                .setHeader("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = null;
        try {
            log.info(String.format("Calling external service for obtain similar products description with id: %s", productId));
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            if (ProductServiceErrorCodeType.PRODUCT_OK.getCode()==response.statusCode()) {
                ProductDetailODTO productDetailODTO = mapper.readValue(response.body(), new TypeReference<ProductDetailODTO>() {});
                return productDetailODTO;
            } else if (ProductServiceErrorCodeType.PRODUCT_NOT_FOUND.getCode()==response.statusCode()) {
                return null;
            } else {
                return null;
            }
        } catch (IOException | InterruptedException e) {
            log.info(String.format("Error calling external service for obtain product details with id: %s", productId));
            return null;
        }
    }
}
