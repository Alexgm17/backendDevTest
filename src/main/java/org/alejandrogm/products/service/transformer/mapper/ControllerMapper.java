package org.alejandrogm.products.service.transformer.mapper;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;
import org.mapstruct.Mapper;

@Mapper
public interface ControllerMapper {

    /**
     * toProductDetail
     *
     * @param productDetailODTO
     * @return
     */
    ProductDetail toProductDetail(ProductDetailODTO productDetailODTO);
}
