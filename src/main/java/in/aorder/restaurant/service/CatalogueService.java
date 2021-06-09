package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.CatalogueCategoryDto;
import in.aorder.restaurant.dto.CreateCatalogueCategoryRequest;

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
}
