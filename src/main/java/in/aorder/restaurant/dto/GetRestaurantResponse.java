package in.aorder.restaurant.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GetRestaurantResponse extends BaseResponse {
    private List<RestaurantDto> restaurants;
}
