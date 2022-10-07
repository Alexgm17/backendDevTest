package org.alejandrogm.products.service.transformer;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;
import org.alejandrogm.products.service.transformer.mapper.ControllerMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductControllerTransformerImpl implements ProductsControllerTransformer{

    @Autowired
    ControllerMapperImpl mapper;

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
