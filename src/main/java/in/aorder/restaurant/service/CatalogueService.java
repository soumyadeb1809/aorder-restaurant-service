package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.*;

import java.util.List;

public interface CatalogueService {

    /**
     * Service to create a new CatalogueCategory.
     *
     * @param request dto
     * @return Id of the created CatalogueCategory
     */
    Integer createCategory(CreateCatalogueCategoryRequest request);

    /**
     * Service to get the list of categories of a restaurant.
     *
     * @param restaurantId of the restaurant
     * @return list of CatalogueCategoryDto
     */
    List<CatalogueCategoryDto> getCategories(Integer restaurantId);

    /**
     * Service to create a new Catalogue.
     *
     * @param request dto
     * @return Id of the created Catalogue
     */
    Integer createCatalogue(CreateCatalogueRequest request);

    /**
     * Service to get the list of catalogue of a restaurant.
     *
     * @param restaurantId of the restaurant
     * @return list of CatalogueDto
     */
    List<CatalogueDto> getCatalogues(Integer restaurantId);

    /**
     * Service to create a new CatalogueItem.
     *
     * @param request dto
     * @return Id of the created CatalogueItem
     */
    Integer createCatalogueItem(CreateCatalogueItemRequest request);

    /**
     * Service to get the list of items that belong to a catalogue.
     *
     * @param catalogueId of the catalogue the items belong to
     * @return list of CatalogueDto
     */
    List<CatalogueItemDto> getCatalogueItems(Integer catalogueId);
}
