package in.aorder.restaurant.repository;

import in.aorder.restaurant.model.Catalogue;
import in.aorder.restaurant.model.FoodCourt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCourtRepository extends JpaRepository<FoodCourt, Integer> {
}
