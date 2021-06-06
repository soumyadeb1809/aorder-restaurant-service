package in.aorder.restaurant.repository;

import in.aorder.restaurant.model.Catalogue;
import in.aorder.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
