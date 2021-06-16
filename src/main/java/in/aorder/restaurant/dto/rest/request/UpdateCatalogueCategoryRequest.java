package in.aorder.restaurant.dto.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateCatalogueCategoryRequest {
    private String name;
    private String description;
}
