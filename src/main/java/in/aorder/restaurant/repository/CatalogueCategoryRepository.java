package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.CatalogueCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueCategoryRepository extends JpaRepository<CatalogueCategory, Integer> {
}
