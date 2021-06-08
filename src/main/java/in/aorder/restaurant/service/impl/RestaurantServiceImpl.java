package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.dto.RestaurantDto;
import in.aorder.restaurant.entity.Restaurant;
import in.aorder.restaurant.repository.RestaurantRepository;
import in.aorder.restaurant.service.RestaurantService;
import in.aorder.restaurant.util.DtoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepo;


    @Transactional
    @Override
    public Integer createRestaurant(CreateRestaurantRequest request) {

        Restaurant restaurant = new Restaurant();

        try {
            populate(restaurant, request);

            restaurantRepo.save(restaurant);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return restaurant.getId();
    }


    @Override
    public List<RestaurantDto> getRestaurant() {
        List<RestaurantDto> restaurants = new ArrayList<>();

        List<Restaurant> restaurantEntries = restaurantRepo.findAll();

        restaurantEntries.forEach(restaurant -> restaurants.add(DtoFactory.createRestaurantDto(restaurant)));

        return restaurants;
    }


    /**
     * Helper method to populate restaurant instance with the request.
     *
     * @param restaurant Restaurant Entity
     * @param request CreateRestaurantRequest dto
     */
    private void populate(Restaurant restaurant, CreateRestaurantRequest request) {
        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setLogoPath(request.getLogoPath());
        restaurant.setLocationId(request.getLocationId());
    }

}
