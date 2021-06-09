package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.CatalogueCategoryDto;
import in.aorder.restaurant.dto.CreateCatalogueCategoryRequest;
import in.aorder.restaurant.entity.CatalogueCategory;
import in.aorder.restaurant.repository.CatalogueCategoryRepository;
import in.aorder.restaurant.service.CatalogueService;
import in.aorder.restaurant.util.DtoFactory;
import in.aorder.restaurant.util.EntityBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    private static final Logger LOGGER = LogManager.getLogger(CatalogueServiceImpl.class);

    @Autowired
    private CatalogueCategoryRepository categoryRepo;


    @Override
    public Integer createCategory(CreateCatalogueCategoryRequest request) {
        CatalogueCategory category = new CatalogueCategory();

        try {
            EntityBuilder.build(category, request);
            categoryRepo.save(category);
        }
        catch (Exception e) {
            LOGGER.error("Error in creating category: ", e);
        }

        return category.getId();
    }

    @Override
    public List<CatalogueCategoryDto> getCategories(Integer restaurantId) {
        List<CatalogueCategoryDto> catalogueCategories = new ArrayList<>();

        try {
            List<CatalogueCategory> categoryRecords = categoryRepo.findAll(restaurantId);
            categoryRecords.forEach(category ->
                    catalogueCategories.add(DtoFactory.createCatalogueCategoryDto(category))
            );
        }
        catch (Exception e) {
            LOGGER.error("Error in fetching categories for restaurant Id: " + restaurantId, e);
        }

        return catalogueCategories;
    }
}
