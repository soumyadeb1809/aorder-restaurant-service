package in.aorder.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCatalogueCategoryRequest {
    private String name;
    private String description;
    private Integer restaurantId;
}
