package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.*;
import in.aorder.restaurant.entity.Catalogue;
import in.aorder.restaurant.entity.CatalogueItem;
import in.aorder.restaurant.model.ResponseMessage;
import in.aorder.restaurant.service.CatalogueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogues")
public class CatalogueController {

    private static final Logger LOGGER = LogManager.getLogger(CatalogueController.class);

    @Autowired
    private CatalogueService catalogueService;

    @GetMapping
    public ResourceListResponse<CatalogueDto> getCatalogues(
            @RequestParam("restaurantId") Integer restaurantId
    ) {
        ResourceListResponse<CatalogueDto> response = new ResourceListResponse<>();

        List<CatalogueDto> catalogues = catalogueService.getCatalogues(restaurantId);
        response.setData(catalogues);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @PostMapping
    public CreateResourceResponse createCatalogue(
            @RequestBody CreateCatalogueRequest request
    ) {
        CreateResourceResponse response = new CreateResourceResponse();

        Integer id = catalogueService.createCatalogue(request);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return  response;
    }

    @GetMapping("/{id}/items")
    public ResourceListResponse<CatalogueItemDto> getCatalogueItems(
            @PathVariable("id") Integer id
    ) {
        ResourceListResponse<CatalogueItemDto> response = new ResourceListResponse<>();

        List<CatalogueItemDto> catalogueItems = catalogueService.getCatalogueItems(id);
        response.setData(catalogueItems);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @PostMapping("/{id}/items")
    public CreateResourceResponse createCatalogueItem(
            @PathVariable("id") Integer catalogueId,
            @RequestBody CreateCatalogueItemRequest request
    ) {
        CreateResourceResponse response = new CreateResourceResponse();

        request.setCatalogueId(catalogueId);

        Integer id = catalogueService.createCatalogueItem(request);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return  response;
    }

    @GetMapping("/categories")
    public ResourceListResponse<CatalogueCategoryDto> getCategories(
            @RequestParam("restaurantId") Integer restaurantId
    ) {
        ResourceListResponse<CatalogueCategoryDto> response = new ResourceListResponse<>();

        List<CatalogueCategoryDto> categories = catalogueService.getCategories(restaurantId);
        response.setData(categories);
        response.setMessage(ResponseMessage.SUCCESS);

        return response;
    }

    @PostMapping("/categories")
    public CreateResourceResponse createCategory(
            @RequestBody CreateCatalogueCategoryRequest request
    ) {
        CreateResourceResponse response = new CreateResourceResponse();

        Integer id = catalogueService.createCategory(request);
        response.setId(id);

        if(id != null) {
            response.setMessage(ResponseMessage.SUCCESS);
        }
        else {
            response.setMessage(ResponseMessage.FAILED);
        }

        return response;
    }

}
