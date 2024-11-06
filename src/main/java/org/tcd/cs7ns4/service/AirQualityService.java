package org.tcd.cs7ns4.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class AirQualityService {

    @Value("${api.token}")
    private String token;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAirQualityData(String city) {
        String url = "https://api.waqi.info/feed/" + city + "/?token=" + token;
        return restTemplate.getForObject(url, String.class);
    }
}
