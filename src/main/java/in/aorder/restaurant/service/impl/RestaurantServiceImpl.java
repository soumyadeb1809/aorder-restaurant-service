package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.dto.RestaurantDto;
import in.aorder.restaurant.entity.Restaurant;
import in.aorder.restaurant.repository.RestaurantRepository;
import in.aorder.restaurant.service.RestaurantService;
import in.aorder.restaurant.util.DtoFactory;
import in.aorder.restaurant.util.EntityBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private static final Logger LOGGER = LogManager.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private RestaurantRepository restaurantRepo;


    @Transactional
    @Override
    public Integer createRestaurant(CreateRestaurantRequest request) {

        Restaurant restaurant = new Restaurant();

        try {
            EntityBuilder.build(restaurant, request);
            restaurantRepo.save(restaurant);
        }
        catch (Exception e) {
            LOGGER.error("Error in creating restaurant: ", e);
        }

        return restaurant.getId();
    }


    @Override
    public List<RestaurantDto> getRestaurants() {
        List<RestaurantDto> restaurants = new ArrayList<>();

        try {
            List<Restaurant> restaurantEntries = restaurantRepo.findAll();

            restaurantEntries.forEach(restaurant -> restaurants.add(DtoFactory.createRestaurantDto(restaurant)));
        }
        catch (Exception e) {
            LOGGER.error("Error in fetching restaurants: ", e);
        }

        return restaurants;
    }

    @Override
    public RestaurantDto getRestaurant(Integer id) {
        RestaurantDto restaurantDto = null;

        try {
            Optional<Restaurant> restaurant = restaurantRepo.findById(id);

            if(restaurant.isPresent()) {
                restaurantDto = DtoFactory.createRestaurantDto(restaurant.get());
            }
        }
        catch (Exception e) {
            LOGGER.error("Error in fetching restaurant with Id: " + id, e);
        }

        return restaurantDto;
    }

}
