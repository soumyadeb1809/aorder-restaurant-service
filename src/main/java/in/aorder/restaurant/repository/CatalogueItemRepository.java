package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.CatalogueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueItemRepository extends JpaRepository<CatalogueItem, Integer> {
}
