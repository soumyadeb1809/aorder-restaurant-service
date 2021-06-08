package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.CreateLocationRequest;
import in.aorder.restaurant.dto.LocationDto;

import java.util.List;

public interface LocationService {

    /**
     * Service to create a new Location.
     *
     * @param request dto
     * @return Id of the created location
     */
    Integer createLocation(CreateLocationRequest request);

    /**
     * Service to get all locations  with the given filters and criteria.
     *
     * @return locations list of LocationDto
     */
    List<LocationDto> getLocation();
}
