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
import java.util.Optional;

@Service
public class CatalogueServiceImpl implements CatalogueService {

    private static final Logger LOG = LogManager.getLogger(CatalogueServiceImpl.class);

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
            LOG.error("Error in creating category", e);
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
            LOG.error("Error in fetching categories for restaurant Id: " + restaurantId, e);
        }

        return catalogueCategories;
    }

    @Override
    public CatalogueCategoryDto updateCategory(Integer id, UpdateCatalogueCategoryRequest request) {
        CatalogueCategoryDto categoryDto = null;

        try {
            Optional<CatalogueCategory> categoryOp = categoryRepo.findById(id);

            if(!categoryOp.isPresent()) {
                LOG.info("CatalogueCategory not found with id: " + id);
                return null;
            }

            CatalogueCategory category = categoryOp.get();
            int updateCount = EntityBuilder.update(category, request);

            if(updateCount != 0) {
                categoryRepo.save(category);
                categoryDto = DtoFactory.createCatalogueCategoryDto(category);
            }
        }
        catch (Exception e) {
            LOG.error("Failed to update CatalogueCategory Id: " + id, e);
        }

        return categoryDto;
    }

    @Override
    public Integer createCatalogue(CreateCatalogueRequest request) {
        Catalogue catalogue = new Catalogue();

        try {
            EntityBuilder.build(catalogue, request);
            catalogueRepo.save(catalogue);
        }
        catch (Exception e) {
            LOG.error("Error in creating catalogue", e);
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
            LOG.error("Error in fetching catalogue list for restaurant Id: " + restaurantId, e);
        }

        return catalogues;
    }

    @Override
    public CatalogueDto updateCatalogue(Integer id, UpdateCatalogueRequest request) {
        CatalogueDto catalogueDto = null;

        try {
            Optional<Catalogue> catalogueOp = catalogueRepo.findById(id);

            if(!catalogueOp.isPresent()) {
                LOG.info("CatalogueCategory not found with id: " + id);
                return null;
            }

            Catalogue catalogue = catalogueOp.get();
            int updateCount = EntityBuilder.update(catalogue, request);

            if(updateCount != 0) {
                catalogueRepo.save(catalogue);
                catalogueDto = DtoFactory.createCatalogueDto(catalogue);
            }
        }
        catch (Exception e) {
            LOG.error("Failed to update Catalogue Id: " + id, e);
        }

        return catalogueDto;
    }

    @Override
    public Integer createCatalogueItem(CreateCatalogueItemRequest request) {
        CatalogueItem catalogueItem = new CatalogueItem();

        try {
            EntityBuilder.build(catalogueItem, request);
            catalogueItemRepo.save(catalogueItem);
        }
        catch (Exception e) {
            LOG.error("Error in creating catalogue item", e);
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
            LOG.error("Error in fetching catalogue items for Id: " + catalogueId, e);
        }

        return catalogueItems;
    }

    @Override
    public CatalogueItemDto updateCatalogueItem(Integer id, UpdateCatalogueItemRequest request) {
        CatalogueItemDto catalogueItemDto = null;

        try {
            Optional<CatalogueItem> catalogueItemOp = catalogueItemRepo.findById(id);

            if(!catalogueItemOp.isPresent()) {
                LOG.info("CatalogueCategory not found with id: " + id);
                return null;
            }

            CatalogueItem catalogueItem = catalogueItemOp.get();
            int updateCount = EntityBuilder.update(catalogueItem, request);

            if(updateCount != 0) {
                catalogueItemRepo.save(catalogueItem);
                catalogueItemDto = DtoFactory.createCatalogueItemDto(catalogueItem);
            }
        }
        catch (Exception e) {
            LOG.error("Failed to update CatalogueItem Id: " + id, e);
        }

        return catalogueItemDto;
    }
}
