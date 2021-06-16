package in.aorder.restaurant.dto.rest.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceResponse<T> extends BaseResponse {
    private T data;
}
