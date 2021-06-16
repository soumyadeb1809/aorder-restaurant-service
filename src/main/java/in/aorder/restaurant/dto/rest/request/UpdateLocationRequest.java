package in.aorder.restaurant.dto.rest.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateLocationRequest {
    private String name;
    private String pin;
    private String latLang;
    private String address;
}
