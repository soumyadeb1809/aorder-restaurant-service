package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.*;
import in.aorder.restaurant.model.ResponseStatus;
import in.aorder.restaurant.service.LocationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private static final Logger LOGGER = LogManager.getLogger(LocationController.class);

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
            response.setStatus(in.aorder.restaurant.model.ResponseStatus.SUCCESS);
        }
        else {
            response.setStatus(ResponseStatus.FAILED);
        }

        return response;
    }

    @GetMapping
    public GenericResourceListResponse<LocationDto> getLocation() {
        GenericResourceListResponse<LocationDto> response = new GenericResourceListResponse<>();

        List<LocationDto> locations = locationService.getLocation();
        response.setData(locations);
        response.setStatus(ResponseStatus.SUCCESS);

        return response;
    }

    @GetMapping("/{id}")
    public GenericResourceResponse<LocationDto> getLocation(
            @PathVariable Integer id
    ) {
        GenericResourceResponse<LocationDto> response = new GenericResourceResponse<>();

        LocationDto location = locationService.getLocation(id);
        response.setData(location);
        response.setStatus(ResponseStatus.SUCCESS);

        return response;
    }
}
