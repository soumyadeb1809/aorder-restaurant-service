package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    /**
     * Service to create a new restaurant.
     *
     * @param request CreateRestaurantRequest dto
     * @return Id of the created restaurant
     */
    Integer createRestaurant(CreateRestaurantRequest request);

    /**
     * Service to get all restaurants with the given filters and criteria.
     *
     * @return restaurants list of RestaurantDto
     */
    List<RestaurantDto> getRestaurant();

}
