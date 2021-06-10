package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.*;
import in.aorder.restaurant.entity.Catalogue;
import in.aorder.restaurant.entity.CatalogueCategory;
import in.aorder.restaurant.entity.CatalogueItem;
import in.aorder.restaurant.repository.CatalogueCategoryRepository;
import in.aorder.restaurant.repository.CatalogueItemRepository;
import in.aorder.restaurant.repository.CatalogueRepository;
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

    @Autowired
    private CatalogueRepository catalogueRepo;

    @Autowired
    private CatalogueItemRepository catalogueItemRepo;


    @Override
    public Integer createCategory(CreateCatalogueCategoryRequest request) {
        CatalogueCategory category = new CatalogueCategory();

        try {
            EntityBuilder.build(category, request);
            categoryRepo.save(category);
        }
        catch (Exception e) {
            LOGGER.error("Error in creating category", e);
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

    @Override
    public Integer createCatalogue(CreateCatalogueRequest request) {
        Catalogue catalogue = new Catalogue();

        try {
            EntityBuilder.build(catalogue, request);
            catalogueRepo.save(catalogue);
        }
        catch (Exception e) {
            LOGGER.error("Error in creating catalogue", e);
        }

        return catalogue.getId();
    }

    @Override
    public List<CatalogueDto> getCatalogues(Integer restaurantId) {
        List<CatalogueDto> catalogues = new ArrayList<>();

        try {
            List<Catalogue> catalogueRecords = catalogueRepo.findAll(restaurantId);
            catalogueRecords.forEach(catalogue -> catalogues.add(DtoFactory.createCatalogueDto(catalogue)));
        }
        catch (Exception e) {
            LOGGER.error("Error in fetching catalogue list for restaurant Id: " + restaurantId, e);
        }

        return catalogues;
    }

    @Override
    public Integer createCatalogueItem(CreateCatalogueItemRequest request) {
        CatalogueItem catalogueItem = new CatalogueItem();

        try {
            EntityBuilder.build(catalogueItem, request);
            catalogueItemRepo.save(catalogueItem);
        }
        catch (Exception e) {
            LOGGER.error("Error in creating catalogue item", e);
        }

        return catalogueItem.getId();
    }

    @Override
    public List<CatalogueItemDto> getCatalogueItems(Integer catalogueId) {
        List<CatalogueItemDto> catalogueItems = new ArrayList<>();

        try {
            List<CatalogueItem> catalogueItemRecords = catalogueItemRepo.findAll(catalogueId);
            catalogueItemRecords.forEach(
                    catalogueItem -> catalogueItems.add(DtoFactory.createCatalogueItemDto(catalogueItem))
            );
        }
        catch (Exception e) {
            LOGGER.error("Error in fetching catalogue items for Id: " + catalogueId, e);
        }

        return catalogueItems;
    }
}
