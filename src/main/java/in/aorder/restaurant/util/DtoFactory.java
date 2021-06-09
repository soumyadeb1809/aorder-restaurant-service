package in.aorder.restaurant.util;

import in.aorder.restaurant.dto.CatalogueCategoryDto;
import in.aorder.restaurant.dto.LocationDto;
import in.aorder.restaurant.dto.RestaurantDto;
import in.aorder.restaurant.entity.CatalogueCategory;
import in.aorder.restaurant.entity.Location;
import in.aorder.restaurant.entity.Restaurant;

/**
 * Utility class containing methods to create DTO objects.
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

    /**
     * Utility method to create LocationDto from Location entity.
     *
     * @param location entity
     * @return locationDto
     */
    public static LocationDto createLocationDto(Location location) {
        LocationDto locationDto = new LocationDto();

        locationDto.setId(location.getId());
        locationDto.setName(location.getName());
        locationDto.setAddress(location.getAddress());
        locationDto.setLatLang(location.getLatLang());
        locationDto.setPin(location.getPin());

        return locationDto;
    }

    /**
     * Utility method to create CatalogueCategoryDto from CatalogueCategory entity.
     *
     * @param category entity
     * @return categoryDto
     */
    public static CatalogueCategoryDto createCatalogueCategoryDto(CatalogueCategory category) {
        CatalogueCategoryDto categoryDto = new CatalogueCategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setRestaurantId(category.getRestaurantId());

        return categoryDto;
    }

}
