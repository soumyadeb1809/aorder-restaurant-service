package in.aorder.restaurant.repository;

import in.aorder.restaurant.model.Catalogue;
import in.aorder.restaurant.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
