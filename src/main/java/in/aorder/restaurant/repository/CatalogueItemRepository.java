package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.CatalogueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueItemRepository extends JpaRepository<CatalogueItem, Integer> {

    @Query("FROM CatalogueItem WHERE catalogueId = :catalogueId")
    List<CatalogueItem> findAll(
            @Param("catalogueId") Integer catalogueId
    );
}
