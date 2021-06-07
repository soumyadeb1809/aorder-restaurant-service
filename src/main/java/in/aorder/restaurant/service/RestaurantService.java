package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.CreateRestaurantRequest;

public interface RestaurantService {

    /**
     * Service to create a new restaurant.
     *
     * @param request CreateRestaurantRequest dto
     * @return Id of the created restaurant
     */
    Integer createRestaurant(CreateRestaurantRequest request);

}
