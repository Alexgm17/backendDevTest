package org.alejandrogm.products.service.transformer.mapper;

import com.alejandrogm.backenddevtest.openapi.model.ProductDetail;
import org.alejandrogm.products.service.dto.output.ProductDetailODTO;

public class ControllerMapper {

    public static ProductDetail toProductDetail(ProductDetailODTO productDetailODTO) {
        if ( productDetailODTO == null ) {
            return null;
        }

        ProductDetail productDetail = new ProductDetail();

        productDetail.setId( productDetailODTO.getId() );
        productDetail.setName( productDetailODTO.getName() );
        productDetail.setPrice( productDetailODTO.getPrice() );
        productDetail.setAvailability( productDetailODTO.getAvailability() );

        return productDetail;
    }
}
