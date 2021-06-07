package in.aorder.restaurant.repository;

import in.aorder.restaurant.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
}
