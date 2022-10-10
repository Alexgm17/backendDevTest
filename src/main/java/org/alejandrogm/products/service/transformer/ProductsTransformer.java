package org.alejandrogm.products.service.transformer;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.dto.output.SimilarProductsDetailsODTO;

import java.util.Set;

public interface ProductsTransformer {

    /**
     * @param similarProductsDetailsODTO
     * @return Set<ProductDetail>
     */
    public Set<ProductDetail> toListSimilarProductsDetails(SimilarProductsDetailsODTO similarProductsDetailsODTO);
}
