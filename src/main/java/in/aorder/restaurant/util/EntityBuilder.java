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
     * Utility method to build CatalogueCategory instance with the request dto.
     *
     * @param category CatalogueCategory Entity
     * @param request CreateCatalogueCategoryRequest dto
     */
    public static void build(CatalogueCategory category, CreateCatalogueCategoryRequest request) {
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        category.setRestaurantId(request.getRestaurantId());
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

}
