package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.FoodCourtRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCourtRestaurantRepository extends JpaRepository<FoodCourtRestaurant, Integer> {
}
