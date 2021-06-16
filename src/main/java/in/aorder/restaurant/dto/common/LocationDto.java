package in.aorder.restaurant.dto.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationDto {
    private Integer id;
    private String name;
    private String pin;
    private String latLang;
    private String address;
}
