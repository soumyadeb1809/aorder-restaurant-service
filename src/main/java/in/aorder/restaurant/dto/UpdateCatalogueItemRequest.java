package in.aorder.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateCatalogueItemRequest {
    private String name;
    private String description;
    private Boolean vegan;
    private Double price;
    private Integer categoryId;
    private Boolean visible;
}
