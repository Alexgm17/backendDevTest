package org.alejandrogm.controller.transformer.mapper;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.service.dto.output.ProductDetailODTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
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
