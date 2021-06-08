package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.dto.CreateRestaurantResponse;
import in.aorder.restaurant.dto.GetRestaurantResponse;
import in.aorder.restaurant.dto.RestaurantDto;
import in.aorder.restaurant.model.ResponseStatus;
import in.aorder.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public ResponseEntity<GetRestaurantResponse> getRestaurant() {

        List<RestaurantDto> restaurants = restaurantService.getRestaurant();
        GetRestaurantResponse response = new GetRestaurantResponse();
        response.setRestaurants(restaurants);
        response.setStatus(ResponseStatus.SUCCESS.toString());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<CreateRestaurantResponse> createRestaurant(
            @RequestBody CreateRestaurantRequest request
    ) {

        Integer id = restaurantService.createRestaurant(request);

        CreateRestaurantResponse response = new CreateRestaurantResponse();
        response.setId(id);

        if(id != null) {
            response.setStatus(ResponseStatus.SUCCESS.toString());
        }
        else {
            response.setStatus(ResponseStatus.FAILED.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/restaurants")
    public String updateRestaurant() {
        return null;
    }

}
