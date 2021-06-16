package in.aorder.restaurant.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CatalogueCategoryDto {
    private Integer id;
    private String name;
    private String description;
    private Integer catalogueId;
}
