package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.*;
import in.aorder.restaurant.model.ResponseMessage;
import in.aorder.restaurant.service.LocationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private static final Logger LOG = LogManager.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @PostMapping
    public CreateResourceResponse createLocation(
            @RequestBody CreateLocationRequest request
    ) {
        CreateResourceResponse response = new CreateResourceResponse();

        Integer id = locationService.createLocation(request);

        if(id != null) {
            response.setId(id);
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return response;
    }

    @GetMapping
    public ResourceListResponse<LocationDto> getLocation() {
        ResourceListResponse<LocationDto> response = new ResourceListResponse<>();

        List<LocationDto> locations = locationService.getLocations();
        response.setData(locations);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @GetMapping("/{id}")
    public ResourceResponse<LocationDto> getLocation(
            @PathVariable Integer id
    ) {
        ResourceResponse<LocationDto> response = new ResourceResponse<>();

        LocationDto location = locationService.getLocation(id);
        response.setData(location);

        if(location != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.NOT_FOUND);
        }

        return response;
    }

    @PutMapping("/{id}")
    public ResourceResponse<LocationDto> updateLocation(
            @PathVariable("id") Integer id,
            @RequestBody UpdateLocationRequest request
    ) {
        ResourceResponse<LocationDto> response = new ResourceResponse<>();

        LocationDto location = locationService.updateLocation(id, request);
        response.setData(location);

        if(location != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.NOT_FOUND);
        }

        return response;
    }
}
