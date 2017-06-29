package com.senz.track.controller;

import com.senz.track.repository.LocationRepository;
import com.senz.track.repository.document.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MapController {

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String LoadMap(ModelMap model,String device) {
        Location location =locationRepository.findOneByDeviceOrderByCreatedTimeDesc(device);
        System.out.println(location);
        model.addAttribute("loc",location);
        return "map";
    }
}