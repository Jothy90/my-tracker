package com.senz.track.controller;

import com.senz.track.repository.LocationRepository;
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

    @Value("${service.file.pathOfAds}")
    private String pathOfAds;

    @RequestMapping(value = "/map", method = RequestMethod.GET)
    public String LoadMap(ModelMap model,String device) {
        model.addAttribute("loc",locationRepository.findOneByDeviceId(device));
        return "map";
    }
}