package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {

    @Query("FROM Catalogue WHERE restaurantId = :restaurantId")
    List<Catalogue> findAll(
            @Param("restaurantId") Integer restaurantId
    );
}
