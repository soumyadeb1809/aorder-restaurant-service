package in.aorder.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FoodCourtDto {
    private Integer id;
    private String name;
    private String description;
    private String logoPath;
    private Integer themeId;
    private Integer locationId;
    private Integer qrId;
}
