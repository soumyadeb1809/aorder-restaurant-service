package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.FoodCourtRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodCourtRestaurantRepository extends JpaRepository<FoodCourtRestaurant, Integer> {

    @Query("FROM FoodCourtRestaurant WHERE foodCourt.id = :foodCourtId AND restaurant.id = :restaurantId")
    Optional<FoodCourtRestaurant> findBy(
            @Param("foodCourtId") Integer foodCourtId,
            @Param("restaurantId") Integer restaurantId
    );

    @Query("FROM FoodCourtRestaurant WHERE foodCourt.id = :foodCourtId")
    List<FoodCourtRestaurant> findAll(
            @Param("foodCourtId") Integer foodCourtId
    );
}
