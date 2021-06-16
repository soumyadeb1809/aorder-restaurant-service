package in.aorder.restaurant.dto.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCatalogueItemRequest {
    private String name;
    private String description;
    private Boolean vegan;
    private Double price;
    private Integer restaurantId;
    private Integer catalogueId;
    private Integer categoryId;
}
