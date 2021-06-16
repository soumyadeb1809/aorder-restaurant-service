package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.common.CatalogueCategoryDto;
import in.aorder.restaurant.dto.common.CatalogueDto;
import in.aorder.restaurant.dto.common.CatalogueItemDto;
import in.aorder.restaurant.dto.rest.request.*;

import java.util.List;

public interface CatalogueService {

    /**
     * Service to create a new CatalogueCategory.
     *
     * @param catalogueId catalogue Id of the restaurant
     * @param request dto
     * @return Id of the created CatalogueCategory
     */
    Integer createCategory(Integer catalogueId, CreateCatalogueCategoryRequest request);

    /**
     * Service to get the list of categories of a restaurant.
     *
     * @param catalogueId of the restaurant
     * @return list of CatalogueCategoryDto
     */
    List<CatalogueCategoryDto> getCategories(Integer catalogueId);

    /**
     * Service to update an existing CatalogueCategory.
     *
     * @param id CatalogueCategory id
     * @param request dto
     * @return updated CatalogueCategoryDto
     */
    CatalogueCategoryDto updateCategory(Integer id, UpdateCatalogueCategoryRequest request);

    /**
     * Service to delete an existing CatalogueCategory.
     *
     * @param id CatalogueCategory id
     * @return deleted CatalogueCategory id
     */
    Integer deleteCategory(Integer id);

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
     * Service to update an existing Catalogue.
     *
     * @param id Catalogue id
     * @param request dto
     * @return updated CatalogueDto
     */
    CatalogueDto updateCatalogue(Integer id, UpdateCatalogueRequest request);

    /**
     * Service to delete an existing Catalogue.
     *
     * @param id Catalogue id
     * @return deleted Catalogue id
     */
    Integer deleteCatalogue(Integer id);

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

    /**
     * Service to update an existing CatalogueItem.
     *
     * @param id CatalogueItem id
     * @param request dto
     * @return updated CatalogueItemDto
     */
    CatalogueItemDto updateCatalogueItem(Integer id, UpdateCatalogueItemRequest request);

    /**
     * Service to delete an existing CatalogueItem.
     *
     * @param id CatalogueItem id
     * @return deleted CatalogueItem id
     */
    Integer deleteCatalogueItem(Integer id);
}
