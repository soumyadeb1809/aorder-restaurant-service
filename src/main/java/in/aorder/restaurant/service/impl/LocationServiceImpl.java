package in.aorder.restaurant.service.impl;

import in.aorder.restaurant.dto.CreateLocationRequest;
import in.aorder.restaurant.dto.LocationDto;
import in.aorder.restaurant.dto.UpdateCatalogueItemRequest;
import in.aorder.restaurant.dto.UpdateLocationRequest;
import in.aorder.restaurant.entity.Location;
import in.aorder.restaurant.repository.LocationRepository;
import in.aorder.restaurant.service.LocationService;
import in.aorder.restaurant.util.DtoFactory;
import in.aorder.restaurant.util.EntityBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOG = LogManager.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationRepository locationRepo;


    @Override
    public Integer createLocation(CreateLocationRequest request) {

        Location location = new Location();

        try {
            EntityBuilder.build(location, request);
            locationRepo.save(location);
        }
        catch (Exception e) {
            LOG.error("Error in creating location: ", e);
        }

        return location.getId();
    }


    @Override
    public List<LocationDto> getLocations() {
        List<LocationDto> locations = new ArrayList<>();

        try {
            List<Location> locationEntries = locationRepo.findAll();
            locationEntries.forEach(location -> locations.add(DtoFactory.createLocationDto(location)));
        }
        catch (Exception e) {
            LOG.error("Error in fetching locations: ", e);
        }

        return locations;
    }


    @Override
    public LocationDto getLocation(Integer id) {

        LocationDto locationDto = null;

        try {
            Optional<Location> location = locationRepo.findById(id);

            if(location.isPresent()) {
                locationDto = DtoFactory.createLocationDto(location.get());
            }
            else {
                LOG.info("Location not found with id: " + id);
            }
        }
        catch (Exception e) {
            LOG.error("Error in fetching location with ID: " + id, e);
        }
        return locationDto;
    }

    @Override
    public LocationDto updateLocation(Integer id, UpdateLocationRequest request) {

        LocationDto locationDto = null;

        try {
            Optional<Location> locationOp = locationRepo.findById(id);

            if(!locationOp.isPresent()) {
                LOG.info("Location not found with id: " + id);
                return null;
            }

            Location location = locationOp.get();
            int updateCount = EntityBuilder.update(location, request);

            if(updateCount != 0) {
                locationRepo.save(location);
                locationDto = DtoFactory.createLocationDto(location);
            }
        }
        catch (Exception e) {
            LOG.error("Failed to update location Id: " + id, e);
        }

        return locationDto;
    }
}
