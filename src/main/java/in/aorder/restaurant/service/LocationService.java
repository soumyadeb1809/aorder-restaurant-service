package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.CreateLocationRequest;
import in.aorder.restaurant.dto.LocationDto;
import in.aorder.restaurant.dto.UpdateCatalogueItemRequest;
import in.aorder.restaurant.dto.UpdateLocationRequest;

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
    List<LocationDto> getLocations();

    /**
     * Service to get location with the provided location id.
     *
     * @param id location id
     * @return LocationDto for the location
     */
    LocationDto getLocation(Integer id);

    /**
     * Service to update an existing Location.
     *
     * @param id location id
     * @param request dto
     * @return updated LocationDto
     */
    LocationDto updateLocation(Integer id, UpdateLocationRequest request);
}
