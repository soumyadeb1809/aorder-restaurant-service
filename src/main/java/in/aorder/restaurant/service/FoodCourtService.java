package in.aorder.restaurant.service;

import in.aorder.restaurant.dto.CreateFoodCourtRequest;
import in.aorder.restaurant.dto.FoodCourtDto;
import in.aorder.restaurant.dto.UpdateFoodCourtRequest;

import java.util.List;

public interface FoodCourtService {

    /**
     * Service to create a new FoodCourt.
     *
     * @param request dto
     * @return Id of the created FoodCourt
     */
    Integer createFoodCourt(CreateFoodCourtRequest request);

    /**
     * Service to get all FoodCourts.
     *
     * @return List of FoodCourtDto
     */
    List<FoodCourtDto> getFoodCourts();

    /**
     * Service to get a FoodCourt by Id.
     *
     * @param id Id of an existing FoodCourt
     * @return instance of FoodCourtDto
     */
    FoodCourtDto getFoodCourt(Integer id);

    /**
     * Service to update a FoodCourt.
     *
     * @param id Id of an existing FoodCourt
     * @param request dto
     * @return updated FoodCourtDto
     */
    FoodCourtDto updateFoodCourt(Integer id, UpdateFoodCourtRequest request);

    /**
     * Service to delete a FoodCourt.
     *
     * @param id Id of an existing FoodCourt
     * @return Id of the deleted FoodCourt
     */
    Integer deleteFoodCourt(Integer id);
}
