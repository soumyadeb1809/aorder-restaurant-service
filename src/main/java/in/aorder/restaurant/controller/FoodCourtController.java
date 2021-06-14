package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.*;
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
        else {
            response.setMessage(ResponseMessage.FAILED);
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
        else {
            response.setMessage(ResponseMessage.FAILED);
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
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return response;
    }
}
