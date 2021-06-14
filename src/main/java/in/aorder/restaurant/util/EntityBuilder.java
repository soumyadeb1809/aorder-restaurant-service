package in.aorder.restaurant.util;

import in.aorder.restaurant.dto.*;
import in.aorder.restaurant.entity.*;

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
     * Utility method to update location instance with the request dto.
     *
     * @param location Location entity
     * @param request UpdateLocationRequest dto
     * @return count of updated properties
     */
    public static int update(Location location, UpdateLocationRequest request) {
        int count = 0;

        if(request.getName() != null) {
            location.setName(request.getName());
            count++;
        }

        if(request.getPin() != null) {
            location.setPin(request.getPin());
            count++;
        }

        if(request.getAddress() != null) {
            location.setAddress(request.getAddress());
            count++;
        }

        if(request.getLatLang() != null) {
            location.setLatLang(request.getLatLang());
            count++;
        }

        return count;
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

    /**
     * Utility method to update restaurant instance with the request dto.
     *
     * @param restaurant Restaurant Entity
     * @param request UpdateRestaurantRequest dto
     * @return count of updated properties
     */
    public static int update(Restaurant restaurant, UpdateRestaurantRequest request) {
        int count = 0;

        if(request.getName() != null) {
            restaurant.setName(request.getName());
            count++;
        }

        if(request.getDescription() != null) {
            restaurant.setDescription(request.getDescription());
            count++;
        }

        if(request.getLogoPath() != null) {
            restaurant.setLogoPath(request.getLogoPath());
            count++;
        }

        if(request.getLocationId() != null) {
            restaurant.setLocationId(request.getLocationId());
            count++;
        }

        if(request.getThemeId() != null) {
            restaurant.setThemeId(request.getThemeId());
            count++;
        }

        if(request.getQrId() != null) {
            restaurant.setQrId(request.getQrId());
            count++;
        }

        return count;
    }

    /**
     * Utility method to build FoodCourt instance with the request dto.
     *
     * @param foodCourt Restaurant Entity
     * @param request CreateRestaurantRequest dto
     */
    public static void build(FoodCourt foodCourt, CreateFoodCourtRequest request) {
        foodCourt.setName(request.getName());
        foodCourt.setDescription(request.getDescription());
        foodCourt.setLogoPath(request.getLogoPath());
        foodCourt.setLocationId(request.getLocationId());
    }

    /**
     * Utility method to update FoodCourt instance with the request dto.
     *
     * @param foodCourt Restaurant Entity
     * @param request UpdateRestaurantRequest dto
     * @return count of updated properties
     */
    public static int update(FoodCourt foodCourt, UpdateFoodCourtRequest request) {
        int count = 0;

        if(request.getName() != null) {
            foodCourt.setName(request.getName());
            count++;
        }

        if(request.getDescription() != null) {
            foodCourt.setDescription(request.getDescription());
            count++;
        }

        if(request.getLogoPath() != null) {
            foodCourt.setLogoPath(request.getLogoPath());
            count++;
        }

        if(request.getLocationId() != null) {
            foodCourt.setLocationId(request.getLocationId());
            count++;
        }

        if(request.getThemeId() != null) {
            foodCourt.setThemeId(request.getThemeId());
            count++;
        }

        if(request.getQrId() != null) {
            foodCourt.setQrId(request.getQrId());
            count++;
        }

        return count;
    }

    /**
     * Utility method to build CatalogueCategory instance with the request dto.
     *
     * @param category CatalogueCategory Entity
     * @param request CreateCatalogueCategoryRequest dto
     */
    public static void build(CatalogueCategory category, CreateCatalogueCategoryRequest request) {
        category.setName(request.getName());
        category.setDescription(request.getDescription());
    }

    /**
     * Utility method to update CatalogueCategory instance with the request dto.
     *
     * @param category CatalogueCategory Entity
     * @param request UpdateCatalogueCategoryRequest dto
     * @return count of updated properties
     */
    public static int update(CatalogueCategory category, UpdateCatalogueCategoryRequest request) {
        int count = 0;

        if(request.getName() != null) {
            category.setName(request.getName());
            count++;
        }

        if(category.getDescription() != null) {
            category.setDescription(request.getDescription());
            count++;
        }

        return count;
    }

    /**
     * Utility method to build Catalogue instance with the request dto.
     *
     * @param catalogue Catalogue entity
     * @param request CreateCatalogueRequest dto
     */
    public static void build(Catalogue catalogue, CreateCatalogueRequest request) {
        catalogue.setName(request.getName());
        catalogue.setRestaurantId(request.getRestaurantId());
    }

    /**
     * Utility method to update Catalogue instance with the request dto.
     *
     * @param catalogue Catalogue entity
     * @param request UpdateCatalogueRequest dto
     * @return count of updated properties
     */
    public static int update(Catalogue catalogue, UpdateCatalogueRequest request) {
        int count = 0;

        if(catalogue.getName() != null) {
            catalogue.setName(request.getName());
            count++;
        }

        return count;
    }

    /**
     * Utility method to build CatalogueItem instance with the request dto.
     *
     * @param catalogueItem CatalogueItem entity
     * @param request CreateCatalogueItemRequest dto
     */
    public static void build(CatalogueItem catalogueItem, CreateCatalogueItemRequest request) {
        catalogueItem.setName(request.getName());
        catalogueItem.setDescription(request.getDescription());
        catalogueItem.setPrice(request.getPrice());
        catalogueItem.setVegan(request.getVegan());
        catalogueItem.setCatalogueId(request.getCatalogueId());
        catalogueItem.setCategoryId(request.getCategoryId());
        catalogueItem.setRestaurantId(request.getRestaurantId());
    }

    /**
     * Utility method to build CatalogueItem instance with the request dto.
     *
     * @param catalogueItem CatalogueItem entity
     * @param request CreateCatalogueItemRequest dto
     * @return count of updated properties
     */
    public static int update(CatalogueItem catalogueItem, UpdateCatalogueItemRequest request) {
        int count = 0;

        if(request.getName() != null) {
            catalogueItem.setName(request.getName());
            count++;
        }

        if(request.getDescription() != null) {
            catalogueItem.setDescription(request.getDescription());
            count++;
        }

        if(request.getPrice() != null) {
            catalogueItem.setPrice(request.getPrice());
            count++;
        }

        if(request.getVegan() != null) {
            catalogueItem.setVegan(request.getVegan());
            count++;
        }

        if(request.getCategoryId() != null) {
            catalogueItem.setCategoryId(request.getCategoryId());
            count++;
        }

        if(request.getVisible() != null) {
            catalogueItem.setVisible(request.getVisible());
            count++;
        }

        return count;
    }
}
