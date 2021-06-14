package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.dto.RestaurantDto;
import in.aorder.restaurant.dto.UpdateRestaurantRequest;
import in.aorder.restaurant.entity.Restaurant;
import in.aorder.restaurant.exception.ResourceNotFoundException;
import in.aorder.restaurant.repository.RestaurantRepository;
import in.aorder.restaurant.service.RestaurantService;
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
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger LOG = LogManager.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private RestaurantRepository restaurantRepo;


    @Transactional
    @Override
    public Integer createRestaurant(CreateRestaurantRequest request) {

        Restaurant restaurant = new Restaurant();

        try {
            EntityBuilder.build(restaurant, request);
            restaurantRepo.save(restaurant);
            LOG.info("Created restaurant Id: " + restaurant.getId());
        }
        catch (Exception e) {
            LOG.error("Error in creating restaurant: ", e);
        }

        return restaurant.getId();
    }

    @Transactional(readOnly = true)
    @Override
    public List<RestaurantDto> getRestaurants() {
        List<RestaurantDto> restaurants = new ArrayList<>();

        try {
            List<Restaurant> restaurantEntries = restaurantRepo.findAll();

            restaurantEntries.forEach(restaurant -> restaurants.add(DtoFactory.createRestaurantDto(restaurant)));
        }
        catch (Exception e) {
            LOG.error("Error in fetching restaurants: ", e);
        }

        return restaurants;
    }

    @Transactional(readOnly = true)
    @Override
    public RestaurantDto getRestaurant(Integer id) {
        RestaurantDto restaurantDto = null;

        try {
            Optional<Restaurant> restaurant = restaurantRepo.findById(id);

            if(restaurant.isPresent()) {
                restaurantDto = DtoFactory.createRestaurantDto(restaurant.get());
            }
            else {
                throw new ResourceNotFoundException("Restaurant not found with id: " + id);
            }
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Error in fetching restaurant with Id: " + id, e);
        }

        return restaurantDto;
    }

    @Transactional
    @Override
    public RestaurantDto updateRestaurant(Integer id, UpdateRestaurantRequest request) {
        RestaurantDto restaurantDto = null;

        try {
            Optional<Restaurant> restaurantOp = restaurantRepo.findById(id);

            if(!restaurantOp.isPresent()) {
                throw new ResourceNotFoundException("Restaurant not found with id: " + id);
            }

            Restaurant restaurant = restaurantOp.get();
            int updateCount = EntityBuilder.update(restaurant, request);
            LOG.info("Updated properties count: " + updateCount);

            if(updateCount != 0) {
                restaurantRepo.save(restaurant);
                LOG.info("Updated restaurant Id: " + id);
            }

            restaurantDto = DtoFactory.createRestaurantDto(restaurant);
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Failed to update Restaurant Id: " + id, e);
        }

        return restaurantDto;
    }

    @Transactional
    @Override
    public Integer deleteRestaurant(Integer id) {
        try {
            Optional<Restaurant> restaurantOp = restaurantRepo.findById(id);

            if(!restaurantOp.isPresent()) {
                throw new ResourceNotFoundException("Restaurant not found with id: " + id);
            }

            Restaurant restaurant = restaurantOp.get();
            restaurant.setDeleted(true);
            restaurantRepo.save(restaurant);
            LOG.info("Deleted restaurant Id: " + id);
        }
        catch (ResourceNotFoundException e) {
            throw e;
        }
        catch (Exception e) {
            LOG.error("Failed to delete Restaurant Id: " + id, e);
        }

        return id;
    }

}
