package org.tcd.cs7ns4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tcd.cs7ns4.entity.AirQualityData;
import org.tcd.cs7ns4.repository.AirQualityRepository;

import java.util.List;

@RestController
@RequestMapping("/api/dominantpollutant")
public class DominantPollutantController {

    @Autowired
    private AirQualityRepository repository;

    @GetMapping("/{city}")
    public List<AirQualityData> getDataByCity(@PathVariable String city) {
        try {
            return repository.findByCity(city);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch dominant pollutant data for city: " + city);
        }
    }
}
