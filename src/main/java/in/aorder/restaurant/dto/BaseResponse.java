package in.aorder.restaurant.dto;

import in.aorder.restaurant.model.ResponseMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse {
    private String message = ResponseMessage.FAILED;
}
