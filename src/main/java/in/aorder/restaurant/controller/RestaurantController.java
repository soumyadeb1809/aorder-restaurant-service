package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.dto.CreateResourceResponse;
import in.aorder.restaurant.dto.GetResourceResponse;
import in.aorder.restaurant.dto.RestaurantDto;
import in.aorder.restaurant.model.ResponseStatus;
import in.aorder.restaurant.service.RestaurantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private static final Logger LOGGER = LogManager.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping
    public CreateResourceResponse createRestaurant(
            @RequestBody CreateRestaurantRequest request
    ) {

        Integer id = restaurantService.createRestaurant(request);

        CreateResourceResponse response = new CreateResourceResponse();
        response.setId(id);

        if(id != null) {
            response.setStatus(ResponseStatus.SUCCESS);
        }
        else {
            response.setStatus(ResponseStatus.FAILED);
        }

        return response;
    }

    @GetMapping
    public GetResourceResponse<RestaurantDto> getRestaurant() {

        List<RestaurantDto> restaurants = restaurantService.getRestaurant();
        GetResourceResponse<RestaurantDto> response = new GetResourceResponse<>();
        response.setData(restaurants);
        response.setStatus(ResponseStatus.SUCCESS);

        return response;
    }

    @PutMapping("/restaurants")
    public String updateRestaurant() {
        return null;
    }

}
