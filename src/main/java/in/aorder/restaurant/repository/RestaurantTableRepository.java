package in.aorder.restaurant.repository;

import in.aorder.restaurant.model.Catalogue;
import in.aorder.restaurant.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Integer> {
}
