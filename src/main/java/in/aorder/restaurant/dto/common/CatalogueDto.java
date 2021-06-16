package in.aorder.restaurant.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CatalogueDto {
    private Integer id;
    private String name;
    private Integer restaurantId;
}
