package com.senz.track.repository;

import com.senz.track.repository.document.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
    Location findOneByDeviceOrderByCreatedTimeDesc(String device);
    Location findOneByDeviceOrderByCreatedTimeAsc(String device);
    Location findOneByDevice(String device);
}
