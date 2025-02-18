package org.alejandrogm.products.transformer;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.products.service.transformer.ProductTransformerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductTransformerTest {

    @InjectMocks
    private ProductTransformerImpl productTransformerImpl;

    @Mock
    private static Set<ProductDetailODTO> listProductsDetails;

    @Mock
    private static SimilarProductsDetailsODTO similarProductsDetails;

    @BeforeAll
    public static void prepareTransformerList () {
        var similarProductsDetails = new SimilarProductsDetailsODTO();
        var productDetail1 = new ProductDetailODTO();
        var productDetail2 = new ProductDetailODTO();
        var productDetail3 = new ProductDetailODTO();
        productDetail1.setId("4");
        productDetail1.setName("Boots");
        productDetail1.setPrice(new BigDecimal(39.99));
        productDetail1.setAvailability(true);
        productDetail2.setId("3");
        productDetail2.setName("Blazer");
        productDetail2.setPrice(new BigDecimal(29.99));
        productDetail2.setAvailability(false);
        productDetail3.setId("2");
        productDetail3.setName("Dress");
        productDetail3.setPrice(new BigDecimal(19.99));
        productDetail3.setAvailability(false);
        listProductsDetails = Set.of(productDetail1, productDetail2, productDetail3);
        similarProductsDetails.setProductDetailODTOS(listProductsDetails);
    }

    @Test
    public void toListSimilarProductsDetails () {
        Set<ProductDetail> expectedProductsDetails = productTransformerImpl.toListSimilarProductsDetails(similarProductsDetails);

        assertNotNull(expectedProductsDetails);
        similarProductsDetails.getProductDetailODTOS().parallelStream().forEach(productDetail -> {
            expectedProductsDetails.stream().forEach(productDetailExpected -> {
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
