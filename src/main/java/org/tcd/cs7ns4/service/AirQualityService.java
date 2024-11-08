package org.tcd.cs7ns4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tcd.cs7ns4.dto.AirQualityResponse;
import org.tcd.cs7ns4.entity.AirQualityData;
import org.tcd.cs7ns4.repository.AirQualityRepository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class AirQualityService {

    @Autowired
    private AirQualityRepository repository;

    private final String token = "904517629a36337ba97a3f46eb5f2751b64dea04";
    private final List<String> cities = Arrays.asList("beijing", "shanghai", "guangzhou");

    public void fetchDataAndSave() {
        RestTemplate restTemplate = new RestTemplate();
        for (String city : cities) {
            String url = "https://api.waqi.info/feed/" + city + "/?token=" + token;
            AirQualityResponse response = restTemplate.getForObject(url, AirQualityResponse.class);

            if ("ok".equals(response.getStatus())) {
                AirQualityData data = new AirQualityData();
                data.setCity(city);
                data.setAqi(response.getData().getAqi());
                data.setDominantPollutant(response.getData().getDominentpol());
                data.setTemperature(response.getData().getIaqi().getT().getV());
                data.setHumidity(response.getData().getIaqi().getH().getV());

                OffsetDateTime offsetDateTime = OffsetDateTime.parse(response.getData().getTime().getIso());
                LocalDateTime localTimestamp = offsetDateTime.toLocalDateTime();
                data.setTimestamp(localTimestamp);

                repository.save(data);
            }
        }
    }
}
