package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.CatalogueCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogueCategoryRepository extends JpaRepository<CatalogueCategory, Integer> {

    @Query("FROM CatalogueCategory WHERE catalogueId = :catalogueId")
    List<CatalogueCategory> findAll(
            @Param("catalogueId") Integer catalogueId
    );
}
