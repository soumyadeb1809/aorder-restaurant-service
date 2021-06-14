package in.aorder.restaurant.util;

import in.aorder.restaurant.dto.*;
import in.aorder.restaurant.entity.*;

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
     * Utility method to create FoodCourtDto from FoodCourt entity.
     *
     * @param foodCourt entity
     * @return restaurantDto
     */
    public static FoodCourtDto createFoodCourtDto(FoodCourt foodCourt) {
        FoodCourtDto foodCourtDto = new FoodCourtDto();

        foodCourtDto.setId(foodCourt.getId());
        foodCourtDto.setName(foodCourt.getName());
        foodCourtDto.setDescription(foodCourt.getDescription());
        foodCourtDto.setLogoPath(foodCourt.getLogoPath());
        foodCourtDto.setLocationId(foodCourt.getLocationId());
        foodCourtDto.setQrId(foodCourt.getQrId());
        foodCourtDto.setThemeId(foodCourt.getThemeId());

        return foodCourtDto;
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
        categoryDto.setCatalogueId(category.getCatalogueId());

        return categoryDto;
    }

    /**
     * Utility method to create CatalogueDto from Catalogue entity.
     *
     * @param catalogue entity
     * @return catalogueDto
     */
    public static CatalogueDto createCatalogueDto(Catalogue catalogue) {
        CatalogueDto catalogueDto = new CatalogueDto();

        catalogueDto.setId(catalogue.getId());
        catalogueDto.setName(catalogue.getName());
        catalogueDto.setRestaurantId(catalogue.getRestaurantId());

        return catalogueDto;
    }

    /**
     * Utility method to create CatalogueItemDto from CatalogueItem entity.
     *
     * @param catalogueItem entity
     * @return catalogueItemDto
     */
    public static CatalogueItemDto createCatalogueItemDto(CatalogueItem catalogueItem) {
        CatalogueItemDto catalogueItemDto = new CatalogueItemDto();

        catalogueItemDto.setId(catalogueItem.getId());
        catalogueItemDto.setName(catalogueItem.getName());
        catalogueItemDto.setDescription(catalogueItem.getDescription());
        catalogueItemDto.setPrice(catalogueItem.getPrice());
        catalogueItemDto.setVegan(catalogueItem.getVegan());
        catalogueItemDto.setVisible(catalogueItem.getVisible());
        catalogueItemDto.setCatalogueId(catalogueItem.getCatalogueId());
        catalogueItemDto.setCategoryId(catalogueItem.getCategoryId());
        catalogueItemDto.setRestaurantId(catalogueItem.getRestaurantId());

        return catalogueItemDto;
    }
}
