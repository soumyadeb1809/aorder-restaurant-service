package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.rest.request.CreateRestaurantRequest;
import in.aorder.restaurant.dto.common.RestaurantDto;
import in.aorder.restaurant.dto.rest.request.UpdateRestaurantRequest;

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
    List<RestaurantDto> getRestaurants();

    /**
     * Service to get restaurant with the given id.
     *
     * @return RestaurantDto of the Restaurant
     */
    RestaurantDto getRestaurant(Integer id);

    /**
     * Service to update an existing restaurant.
     *
     * @param id of the restaurant
     * @param request dto
     * @return updated RestaurantDto
     */
    RestaurantDto updateRestaurant(Integer id, UpdateRestaurantRequest request);

    /**
     * Service to update an existing restaurant.
     *
     * @param id of the restaurant
     * @return id of the deleted restaurant
     */
    Integer deleteRestaurant(Integer id);
}
