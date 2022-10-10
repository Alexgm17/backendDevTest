package org.alejandrogm.products;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.controller.ProductsController;
import org.alejandrogm.products.service.ProductsService;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.products.service.error.CustomApiException;
import org.alejandrogm.products.service.transformer.ProductsTransformer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductsControllerTest {

    @Mock
    private ProductsService productsService;

    @Mock
    private ProductsTransformer productsTransformer;

    @Mock
    private Set<ProductDetail> listProducts;

    @InjectMocks
    private ProductsController productsController;

    @BeforeTestClass
    public void prepareTransformerList() {
        var productDetail1 = new ProductDetail();
        var productDetail2 = new ProductDetail();
        var productDetail3 = new ProductDetail();
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
        listProducts = Set.of(productDetail1, productDetail2, productDetail3);
    }

    @Test
    public void testGetProductSimilar(){
        var product1 = new ProductDetailODTO("4", "Boots", new BigDecimal(39.99), true);
        var product2 = new ProductDetailODTO("3", "Blazer", new BigDecimal(29.99), false);
        var product3 = new ProductDetailODTO("2", "Dress", new BigDecimal(19.99), false);

        Set<ProductDetailODTO> products = Set.of(product1, product2, product3);
        SimilarProductsDetailsODTO similarProductsDetailsODTO = new SimilarProductsDetailsODTO(products);

        when(productsService.getSimilarProductsDetails("1")).thenReturn(similarProductsDetailsODTO);
        when(productsTransformer.toListSimilarProductsDetails(similarProductsDetailsODTO)).thenReturn(listProducts);

        ResponseEntity<Set<ProductDetail>> actual = productsController.getProductSimilar("1");

        assertEquals(HttpStatus.OK, actual.getStatusCode());
    }

    @Test
    public void testErrorProductNotFound() {
        Mockito.when(productsService.getSimilarProductsDetails("6")).thenThrow(CustomApiException.class);
    }
}
