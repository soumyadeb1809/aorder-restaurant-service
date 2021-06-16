package in.aorder.restaurant.dto.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateRestaurantRequest {
    private String name;
    private String description;
    private String logoPath;
    private Integer locationId;
    private Integer themeId;
    private Integer qrId;
}
