package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.dto.CreateRestaurantResponse;
import in.aorder.restaurant.model.ResponseStatus;
import in.aorder.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public String getRestaurant() {
        return null;
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
