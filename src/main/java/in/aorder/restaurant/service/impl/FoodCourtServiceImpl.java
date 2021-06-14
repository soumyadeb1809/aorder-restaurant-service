package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.CreateFoodCourtRequest;
import in.aorder.restaurant.dto.FoodCourtDto;
import in.aorder.restaurant.dto.UpdateFoodCourtRequest;
import in.aorder.restaurant.entity.FoodCourt;
import in.aorder.restaurant.exception.ResourceNotFoundException;
import in.aorder.restaurant.repository.FoodCourtRepository;
import in.aorder.restaurant.service.FoodCourtService;
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
public class FoodCourtServiceImpl implements FoodCourtService {

    private static final Logger LOG = LogManager.getLogger(FoodCourtServiceImpl.class);

    @Autowired
    private FoodCourtRepository fcRepo;

    @Override
    public Integer createFoodCourt(CreateFoodCourtRequest request) {
        FoodCourt foodCourt = new FoodCourt();

        try {
            EntityBuilder.build(foodCourt, request);
            fcRepo.save(foodCourt);
            LOG.info("Created FoodCourt Id: " + foodCourt.getId());
        }
        catch (Exception e) {
            LOG.error("Error in creating FoodCourt", e);
        }

        return foodCourt.getId();
    }

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
        catch (Exception e) {
            LOG.error("Error in fetching FoodCourt Id: " + id, e);
        }

        return foodCourtDto;
    }

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
        catch (Exception e) {
            LOG.error("Error in fetching FoodCourt Id: " + id, e);
        }

        return foodCourtDto;
    }

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
        catch (Exception e) {
            LOG.error("Error in deleting FoodCourt Id: " + id);
        }

        return id;
    }
}
