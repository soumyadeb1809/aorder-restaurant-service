package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.CreateRestaurantRequest;
import in.aorder.restaurant.entity.Restaurant;
import in.aorder.restaurant.repository.RestaurantRepository;
import in.aorder.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
