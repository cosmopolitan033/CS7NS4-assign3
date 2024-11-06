package org.tcd.cs7ns4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tcd.cs7ns4.service.AirQualityService;

@RestController
public class AirQualityController {

    @Autowired
    private AirQualityService airQualityService;

    @GetMapping("/air-quality")
    public String getAirQuality(@RequestParam String city) {
        return airQualityService.getAirQualityData(city);
    }
}
