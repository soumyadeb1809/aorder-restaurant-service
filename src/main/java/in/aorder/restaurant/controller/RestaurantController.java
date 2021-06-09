package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.*;
import in.aorder.restaurant.model.ResponseMessage;
import in.aorder.restaurant.service.RestaurantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return response;
    }

    @GetMapping
    public ResourceListResponse<RestaurantDto> getRestaurant() {

        List<RestaurantDto> restaurants = restaurantService.getRestaurants();
        ResourceListResponse<RestaurantDto> response = new ResourceListResponse<>();
        response.setData(restaurants);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @GetMapping("/{id}")
    public ResourceResponse<RestaurantDto> getRestaurant(
            @PathVariable Integer id
    ) {
       ResourceResponse<RestaurantDto> response = new ResourceResponse<>();

       RestaurantDto restaurant = restaurantService.getRestaurant(id);
       response.setData(restaurant);
       response.setMessage(ResponseMessage.SUCCESS);

       return response;
    }

    @PutMapping
    public String updateRestaurant() {
        return null;
    }

}
