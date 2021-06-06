package in.aorder.restaurant.repository;

import in.aorder.restaurant.model.Catalogue;
import in.aorder.restaurant.model.CatalogueItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogueItemRepository extends JpaRepository<CatalogueItem, Integer> {
}
