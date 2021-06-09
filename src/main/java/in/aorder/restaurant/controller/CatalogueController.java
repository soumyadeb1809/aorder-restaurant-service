package in.aorder.restaurant.controller;

import in.aorder.restaurant.dto.CatalogueCategoryDto;
import in.aorder.restaurant.dto.CreateCatalogueCategoryRequest;
import in.aorder.restaurant.dto.CreateResourceResponse;
import in.aorder.restaurant.dto.ResourceListResponse;
import in.aorder.restaurant.model.ResponseMessage;
import in.aorder.restaurant.service.CatalogueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class CatalogueController {

    private static final Logger LOGGER = LogManager.getLogger(CatalogueController.class);

    @Autowired
    private CatalogueService catalogueService;

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
