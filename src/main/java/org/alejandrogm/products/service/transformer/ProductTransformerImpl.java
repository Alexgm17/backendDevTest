package org.alejandrogm.products.service.transformer;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.products.service.transformer.mapper.ControllerMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductTransformerImpl implements ProductsTransformer {

    @Override
    public Set<ProductDetail> toListSimilarProductsDetails (SimilarProductsDetailsODTO similarProductsDetailsODTO) {
        var listSimilarProducts = new HashSet<ProductDetail>();
        if (similarProductsDetailsODTO != null && similarProductsDetailsODTO.getProductDetailODTOS() != null) {
            similarProductsDetailsODTO.getProductDetailODTOS().parallelStream().forEach(productDetail ->
                    listSimilarProducts.add(ControllerMapper.toProductDetail(productDetail)));
        }
        return listSimilarProducts;
    }
}
