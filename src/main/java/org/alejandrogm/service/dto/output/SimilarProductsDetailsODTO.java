package org.alejandrogm.service.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.alejandrogm.service.dto.ProductDetailDTO;

import java.util.Set;

/**
 * @author agallegomorilla
 *
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SimilarProductsDetailsODTO  {

    Set<ProductDetailDTO> productDetailDTOS;
}
