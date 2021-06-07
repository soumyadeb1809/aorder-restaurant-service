package in.aorder.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateRestaurantRequest {

    private String name;
    private String description;
    private String logoPath;
    private Integer locationId;

}
