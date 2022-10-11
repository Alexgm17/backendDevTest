package org.alejandrogm.products.service;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductsService productsService;
    @Mock
    private static Set<ProductDetailODTO> listProductsDetails;

    @Mock
    private static SimilarProductsDetailsODTO similarProductsDetails;

    @BeforeAll
    public static void prepareList () {
        var similarProductsDetails = new SimilarProductsDetailsODTO();
        var productDetail1 = new ProductDetailODTO();
        var productDetail2 = new ProductDetailODTO();
        var productDetail3 = new ProductDetailODTO();
        productDetail1.setId("1000");
        productDetail1.setName("Coat");
        productDetail1.setPrice(new BigDecimal(89.99));
        productDetail1.setAvailability(true);
        productDetail2.setId("3");
        productDetail2.setName("Blazer");
        productDetail2.setPrice(new BigDecimal(29.99));
        productDetail2.setAvailability(false);
        productDetail3.setId("100");
        productDetail3.setName("Trousers");
        productDetail3.setPrice(new BigDecimal(49.99));
        productDetail3.setAvailability(false);
        listProductsDetails = Set.of(productDetail1, productDetail2, productDetail3);
        similarProductsDetails.setProductDetailODTOS(listProductsDetails);
    }

    @Test
    public void getSimilarProductsDetailsTest() {

        SimilarProductsDetailsODTO similarProductsDetailsODTOExpected = productsService.getSimilarProductsDetails("8");

        similarProductsDetails.getProductDetailODTOS().parallelStream().forEach(productDetail -> {
            similarProductsDetailsODTOExpected.getProductDetailODTOS().stream().forEach(productDetailExpected -> {
                assertAll(() -> {
                    assertEquals(productDetail.getId(), productDetailExpected.getId());
                }, () -> {
                    assertEquals(productDetail.getName(), productDetailExpected.getName());
                }, () -> {
                    assertEquals(productDetail.getPrice(), productDetailExpected.getPrice());
                }, () -> {
                    assertEquals(productDetail.getAvailability(), productDetailExpected.getAvailability());
                });
            });
        });
    }
}
