package org.tcd.cs7ns4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tcd.cs7ns4.entity.AirQualityData;
import org.tcd.cs7ns4.repository.AirQualityRepository;

import java.util.List;

@RestController
@RequestMapping("/api/airquality")
public class AirQualityController {

    @Autowired
    private AirQualityRepository repository;

    @GetMapping("/{city}")
    public List<AirQualityData> getDataByCity(@PathVariable String city) {
        return repository.findByCity(city);
    }
}
