package in.aorder.restaurant.util;

import in.aorder.restaurant.dto.CreateLocationRequest;
import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.entity.Location;
import in.aorder.restaurant.entity.Restaurant;

/**
 * Class containing utility methods to work with entities.
 */
public class EntityBuilder {

    /**
     * Utility method to build location instance with the request dto.
     *
     * @param location Location entity
     * @param request CreateRestaurantRequest dto
     */
    public static void build(Location location, CreateLocationRequest request) {
        location.setName(request.getName());
        location.setPin(request.getPin());
        location.setAddress(request.getAddress());
        location.setLatLang(request.getLatLang());
    }


    /**
     * Utility method to build restaurant instance with the request dto.
     *
     * @param restaurant Restaurant Entity
     * @param request CreateRestaurantRequest dto
     */
    public static void build(Restaurant restaurant, CreateRestaurantRequest request) {
        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setLogoPath(request.getLogoPath());
        restaurant.setLocationId(request.getLocationId());
    }

}
