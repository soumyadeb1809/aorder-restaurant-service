package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.common.FoodCourtDto;
import in.aorder.restaurant.dto.common.RestaurantDto;
import in.aorder.restaurant.dto.rest.request.CreateFoodCourtRequest;
import in.aorder.restaurant.dto.rest.request.UpdateFoodCourtRequest;
import in.aorder.restaurant.dto.rest.response.CreateResourceResponse;
import in.aorder.restaurant.dto.rest.response.DeleteResourceResponse;
import in.aorder.restaurant.dto.rest.response.ResourceListResponse;
import in.aorder.restaurant.dto.rest.response.ResourceResponse;
import in.aorder.restaurant.model.ResponseMessage;
import in.aorder.restaurant.service.FoodCourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodcourts")
public class FoodCourtController {

    @Autowired
    private FoodCourtService fcService;

    @GetMapping
    public ResourceListResponse<FoodCourtDto> getFoodCourts() {
        ResourceListResponse<FoodCourtDto> response = new ResourceListResponse<>();

        List<FoodCourtDto> foodCourts = fcService.getFoodCourts();
        response.setData(foodCourts);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @GetMapping("/{id}")
    public ResourceResponse<FoodCourtDto> getFoodCourt(
            @PathVariable("id") Integer id
    ) {
        ResourceResponse<FoodCourtDto> response = new ResourceResponse<>();

        FoodCourtDto foodCourt = fcService.getFoodCourt(id);
        response.setData(foodCourt);

        if(foodCourt != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }

    @PostMapping
    public CreateResourceResponse createFoodCourt(
            @RequestBody CreateFoodCourtRequest request
    ) {
        CreateResourceResponse response = new CreateResourceResponse();

        Integer id = fcService.createFoodCourt(request);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }

    @PutMapping("/{id}")
    public ResourceResponse<FoodCourtDto> updateFoodCourt(
            @PathVariable("id") Integer id,
            @RequestBody UpdateFoodCourtRequest request
    ) {
        ResourceResponse<FoodCourtDto> response = new ResourceResponse<>();

        FoodCourtDto foodCourt = fcService.updateFoodCourt(id, request);
        response.setData(foodCourt);

        if(foodCourt != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }

    @DeleteMapping("/{id}")
    public DeleteResourceResponse deleteFoodCourt(
            @PathVariable("id") Integer id
    ) {
        DeleteResourceResponse response = new DeleteResourceResponse();

        id = fcService.deleteFoodCourt(id);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }

    @PostMapping("/{id}/restaurants/{restaurantId}")
    public CreateResourceResponse addRestaurant(
            @PathVariable("id") Integer fcId,
            @PathVariable("restaurantId") Integer restaurantId
    ) {
        CreateResourceResponse response = new CreateResourceResponse();

        restaurantId = fcService.addRestaurant(fcId, restaurantId);
        response.setId(restaurantId);

        if(restaurantId != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }

    @GetMapping("/{id}/restaurants")
    public ResourceListResponse<RestaurantDto> getRestaurants(
            @PathVariable("id") Integer fcId
    ) {
        ResourceListResponse<RestaurantDto> response = new ResourceListResponse<>();

        List<RestaurantDto> restaurants = fcService.getRestaurants(fcId);
        response.setData(restaurants);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @DeleteMapping("/{id}/restaurants/{restaurantId}")
    public DeleteResourceResponse removeRestaurant(
            @PathVariable("id") Integer fcId,
            @PathVariable("restaurantId") Integer restaurantId
    ) {
        DeleteResourceResponse response = new DeleteResourceResponse();

        restaurantId = fcService.removeRestaurant(fcId, restaurantId);
        response.setId(restaurantId);

        if(restaurantId != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }

        return response;
    }
}
