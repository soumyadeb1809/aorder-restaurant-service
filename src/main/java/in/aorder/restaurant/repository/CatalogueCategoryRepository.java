package in.aorder.restaurant.repository;

import in.aorder.restaurant.model.Catalogue;
import in.aorder.restaurant.model.CatalogueCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueCategoryRepository extends JpaRepository<CatalogueCategory, Integer> {
}
