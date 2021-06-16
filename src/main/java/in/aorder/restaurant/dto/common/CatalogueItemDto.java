package in.aorder.restaurant.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CatalogueItemDto {
    private Integer id;
    private String name;
    private String description;
    private Boolean vegan;
    private Double price;
    private Integer restaurantId;
    private Integer catalogueId;
    private Integer categoryId;
    private Boolean visible;
}
