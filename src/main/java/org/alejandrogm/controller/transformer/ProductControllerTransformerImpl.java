package org.alejandrogm.controller.transformer;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import jakarta.inject.Inject;
import org.alejandrogm.service.dto.output.ProductDetailODTO;
import org.alejandrogm.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.controller.transformer.mapper.ControllerMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductControllerTransformerImpl implements ProductsControllerTransformer{

    @Inject
    private ControllerMapper mapper;

    @Override
    public Set<ProductDetail> toListSimilarProductsDetails (SimilarProductsDetailsODTO similarProductsDetailsODTO) {
        var listSimilarProducts = new HashSet<ProductDetail>();
        if (similarProductsDetailsODTO != null && similarProductsDetailsODTO.getProductDetailODTOS() != null) {
            for (ProductDetailODTO productDetail : similarProductsDetailsODTO.getProductDetailODTOS()) {
                listSimilarProducts.add(mapper.toProductDetail(productDetail));
            }
        }
        return listSimilarProducts;
    }
}
