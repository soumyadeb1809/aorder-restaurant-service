package in.aorder.restaurant.repository;

import in.aorder.restaurant.model.Catalogue;
import in.aorder.restaurant.model.FoodCourtRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCourtRestaurantRepository extends JpaRepository<FoodCourtRestaurant, Integer> {
}
