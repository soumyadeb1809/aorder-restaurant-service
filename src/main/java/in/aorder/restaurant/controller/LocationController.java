package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.CreateLocationRequest;
import in.aorder.restaurant.dto.CreateResourceResponse;
import in.aorder.restaurant.dto.GetResourceResponse;
import in.aorder.restaurant.dto.LocationDto;
import in.aorder.restaurant.model.ResponseStatus;
import in.aorder.restaurant.service.LocationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public GetResourceResponse<LocationDto> getLocation() {
        GetResourceResponse<LocationDto> response = new GetResourceResponse<>();

        List<LocationDto> locations = locationService.getLocation();
        response.setData(locations);
        response.setStatus(ResponseStatus.SUCCESS);

        return response;
    }

}
