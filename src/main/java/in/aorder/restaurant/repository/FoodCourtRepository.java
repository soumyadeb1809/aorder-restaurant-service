package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.FoodCourt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCourtRepository extends JpaRepository<FoodCourt, Integer> {
}
