package in.aorder.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateLocationRequest {
    private String name;
    private String pin;
    private String latLang;
    private String address;
}
