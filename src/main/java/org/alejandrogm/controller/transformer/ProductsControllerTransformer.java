package org.alejandrogm.controller.transformer;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.service.dto.output.SimilarProductsDetailsODTO;

import java.util.Set;

public interface ProductsControllerTransformer {

    /**
     * @param similarProductsDetailsODTO
     * @return Set<ProductDetail>
     */
    public Set<ProductDetail> toListSimilarProductsDetails(SimilarProductsDetailsODTO similarProductsDetailsODTO);
}
