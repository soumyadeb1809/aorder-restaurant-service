package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.rest.request.CreateFoodCourtRequest;
import in.aorder.restaurant.dto.common.FoodCourtDto;
import in.aorder.restaurant.dto.common.RestaurantDto;
import in.aorder.restaurant.dto.rest.request.UpdateFoodCourtRequest;
import in.aorder.restaurant.entity.FoodCourt;
import in.aorder.restaurant.entity.FoodCourtRestaurant;
import in.aorder.restaurant.exception.ResourceNotFoundException;
import in.aorder.restaurant.repository.FoodCourtRepository;
import in.aorder.restaurant.repository.FoodCourtRestaurantRepository;
import in.aorder.restaurant.service.FoodCourtService;
import in.aorder.restaurant.util.DtoFactory;
import in.aorder.restaurant.util.EntityBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodCourtServiceImpl implements FoodCourtService {

    private static final Logger LOG = LogManager.getLogger(FoodCourtServiceImpl.class);

    @Autowired
    private FoodCourtRepository fcRepo;

    @Autowired
    private FoodCourtRestaurantRepository fcRestaurantRepo;

    @Transactional
    @Override
    public Integer createFoodCourt(CreateFoodCourtRequest request) {
        FoodCourt foodCourt = new FoodCourt();

        try {
            EntityBuilder.build(foodCourt, request);
            fcRepo.save(foodCourt);
            LOG.info("Created FoodCourt Id: " + foodCourt.getId());
        }
        catch (Exception e) {
            LOG.error("Error creating FoodCourt", e);
        }

        return foodCourt.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<FoodCourtDto> getFoodCourts() {
        List<FoodCourtDto> foodCourts = new ArrayList<>();

        try {
            List<FoodCourt> foodCourtRecords = fcRepo.findAll();
            foodCourtRecords.forEach(foodCourt -> foodCourts.add(DtoFactory.createFoodCourtDto(foodCourt)));
        }
        catch (Exception e) {
            LOG.error("Error in fetching FoodCourts", e);
        }

        return foodCourts;
    }

    @Transactional(readOnly = true)
    @Override
    public FoodCourtDto getFoodCourt(Integer id) {
        FoodCourtDto foodCourtDto = null;

        try {
            Optional<FoodCourt> foodCourtOp = fcRepo.findById(id);

            if(!foodCourtOp.isPresent()) {
                throw new ResourceNotFoundException("FoodCourt not found with Id: " + id);
            }

            foodCourtDto = DtoFactory.createFoodCourtDto(foodCourtOp.get());
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Error fetching FoodCourt Id: " + id, e);
        }

        return foodCourtDto;
    }

    @Transactional
    @Override
    public FoodCourtDto updateFoodCourt(Integer id, UpdateFoodCourtRequest request) {
        FoodCourtDto foodCourtDto = null;

        try {
            Optional<FoodCourt> foodCourtOp = fcRepo.findById(id);

            if(!foodCourtOp.isPresent()) {
                throw new ResourceNotFoundException("FoodCourt not found with Id: " + id);
            }

            FoodCourt foodCourt = foodCourtOp.get();
            int updateCount = EntityBuilder.update(foodCourt, request);

            if(updateCount != 0) {
                fcRepo.save(foodCourt);
                LOG.info("Updated FoodCourt Id: " + id);
            }

            foodCourtDto = DtoFactory.createFoodCourtDto(foodCourt);
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Error fetching FoodCourt Id: " + id, e);
        }

        return foodCourtDto;
    }

    @Transactional
    @Override
    public Integer deleteFoodCourt(Integer id) {
        try {
            Optional<FoodCourt> foodCourtOp = fcRepo.findById(id);

            if(!foodCourtOp.isPresent()) {
                throw new ResourceNotFoundException("FoodCourt not found with Id: " + id);
            }

            FoodCourt foodCourt = foodCourtOp.get();
            foodCourt.setDeleted(true);
            fcRepo.save(foodCourt);
            LOG.info("Deleted FoodCourt Id: " + id);
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Error in deleting FoodCourt Id: " + id);
        }

        return id;
    }

    @Transactional
    @Override
    public Integer addRestaurant(Integer foodCourtId, Integer restaurantId) {
        FoodCourtRestaurant fcRestaurant = new FoodCourtRestaurant();

        try {
            EntityBuilder.build(fcRestaurant, foodCourtId, restaurantId);
            fcRestaurantRepo.save(fcRestaurant);
            LOG.info("Added Restaurant Id: " + restaurantId + ", in FoodCourt Id: " + foodCourtId);
        }
        catch (Exception e) {
            LOG.error("Error adding restaurantId: " + restaurantId + " in foodCourtId: " + foodCourtId, e);
        }

        return restaurantId;
    }

    @Transactional(readOnly = true)
    @Override
    public List<RestaurantDto> getRestaurants(Integer foodCourtId) {
        List<RestaurantDto> restaurants = new ArrayList<>();

        try {
            Optional<FoodCourt> foodCourtOp = fcRepo.findById(foodCourtId);

            if(!foodCourtOp.isPresent()) {
                throw new ResourceNotFoundException("FoodCourt not found with Id: " + foodCourtId);
            }

            List<FoodCourtRestaurant> fcRestaurants = fcRestaurantRepo.findAll(foodCourtOp.get().getId());
            fcRestaurants.forEach(fcRestaurant ->
                    restaurants.add(DtoFactory.createRestaurantDto(fcRestaurant.getRestaurant()))
            );
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Error fetching Restaurants for FoodCourt Id: " + foodCourtId, e);
        }

        return restaurants;
    }

    @Transactional
    @Override
    public Integer removeRestaurant(Integer foodCourtId, Integer restaurantId) {
        try {
            Optional<FoodCourtRestaurant> fcRestaurantOp = fcRestaurantRepo.findBy(foodCourtId, restaurantId);

            if(!fcRestaurantOp.isPresent()) {
                throw new ResourceNotFoundException("Restaurant is not part of FoodCourt");
            }

            FoodCourtRestaurant fcRestaurant = fcRestaurantOp.get();
            fcRestaurant.setDeleted(true);
            fcRestaurantRepo.save(fcRestaurant);
            LOG.info("Deleted restaurant Id: " + restaurantId + " from foodCourt Id: " + foodCourtId);
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Error removing restaurantId: " + restaurantId
                    + " from foodCourtId: " + foodCourtId, e);
        }

        return restaurantId;
    }
}
