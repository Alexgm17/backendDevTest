package org.alejandrogm.products.service.rest;

import com.alejandrogm.backenddevtest.openapi.api.ProductApi;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
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
            .connectTimeout(Duration.ofSeconds(30))
            .build();

    private static final Logger log = Logger.getLogger(ProductApi.class.getName());

    @Inject
    private Environment env;

    @Value("${rest-integration.systems.EXISTING_APIS.endpoints.SIMILAR_PRODUCTS.url}")
    private static String URL_GETSIMILARPRODUCTS;

    public static List<String> createRequestSimilarProductsIds (String productId) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:3001/product/"+productId+"/similarids"))
                .setHeader("Content-Type", "application/json")
                .build();

        log.info("Request createRequestSimilarProductsIds: "+ request);

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            List<String> similarProductsIds = mapper.readValue(response.body(), new TypeReference<List<String>>() {});
            return similarProductsIds;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static ProductDetailODTO createRequestGetProductDetails (String productId) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:3001/product/"+productId))
                .setHeader("Content-Type", "application/json")
                .build();

        log.info("Request createRequestGetProductDetails: "+ request);

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            ProductDetailODTO productDetailODTO = mapper.readValue(response.body(), new TypeReference<ProductDetailODTO>() {});
            return productDetailODTO;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
