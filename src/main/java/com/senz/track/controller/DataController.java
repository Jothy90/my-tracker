package com.senz.track.controller;

import com.senz.track.platform.DOMessage;
import com.senz.track.repository.LocationRepository;
import com.senz.track.repository.document.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataController {

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    public String LoadMap(@RequestBody DOMessage doMessage) {
        Location location= new Location(doMessage.getMessage().split(":"),doMessage.getDeviceId());
        locationRepository.save(location);
        return "Success";
    }
}