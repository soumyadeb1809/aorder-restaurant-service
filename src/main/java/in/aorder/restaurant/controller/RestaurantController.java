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

    private static final Logger LOG = LogManager.getLogger(RestaurantController.class);

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

        return response;
    }

    @GetMapping
    public ResourceListResponse<RestaurantDto> getRestaurants() {

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

        if(restaurant != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

       return response;
    }

    @PutMapping("/{id}")
    public ResourceResponse<RestaurantDto> updateRestaurant(
            @PathVariable Integer id,
            @RequestBody UpdateRestaurantRequest request
    ) {
        ResourceResponse<RestaurantDto> response = new ResourceResponse<>();

        RestaurantDto restaurant = restaurantService.updateRestaurant(id, request);
        response.setData(restaurant);

        if(restaurant != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public DeleteResourceResponse deleteRestaurant(
            @PathVariable("id") Integer id
    ) {
        DeleteResourceResponse response = new DeleteResourceResponse();

        id = restaurantService.deleteRestaurant(id);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }

}
