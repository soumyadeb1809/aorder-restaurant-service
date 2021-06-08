package in.aorder.restaurant.util;

import in.aorder.restaurant.dto.RestaurantDto;
import in.aorder.restaurant.entity.Restaurant;

/**
 * Utility class containing methods to create DTO objects.
 *
 * @author soumyadeb
 */
public class DtoFactory {

    /**
     * Utility method to create RestaurantDto from Restaurant entity.
     *
     * @param restaurant entity
     * @return restaurantDto
     */
    public static RestaurantDto createRestaurantDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();

        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setDescription(restaurant.getDescription());
        restaurantDto.setLogoPath(restaurant.getLogoPath());
        restaurantDto.setLocationId(restaurant.getLocationId());
        restaurantDto.setQrId(restaurant.getQrId());
        restaurantDto.setThemeId(restaurant.getThemeId());

        return restaurantDto;
    }

}
