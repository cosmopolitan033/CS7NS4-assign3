package org.tcd.cs7ns4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tcd.cs7ns4.dto.AirQualityResponse;
import org.tcd.cs7ns4.entity.AirQualityData;
import org.tcd.cs7ns4.repository.AirQualityRepository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AirQualityService {

//    @Autowired
    private final AirQualityRepository repository;
    private final String token;
    private final List<String> cities;

    // 使用构造器注入的方式读取配置文件中的值
    public AirQualityService(AirQualityRepository repository,
                             @Value("${airquality.api.token}") String token,
                             @Value("${airquality.api.cities}") String cities) {
        this.repository = repository;
        this.token = token;
        this.cities = Arrays.asList(cities.split(","));
    }

    public void fetchDataAndSave() {
        RestTemplate restTemplate = new RestTemplate();
        for (String city : cities) {
            String formattedCity = city.replace("_", "");
            System.out.println("fuck "+formattedCity);
            String url = "https://api.waqi.info/feed/" + formattedCity + "/?token=" + token;
            AirQualityResponse response = restTemplate.getForObject(url, AirQualityResponse.class);

            assert response != null;
            if ("ok".equals(response.getStatus())) {
                AirQualityData data = new AirQualityData();
                data.setCity(city);
                data.setAqi(Optional.ofNullable(response.getData().getAqi()).orElse(0));
                data.setDominantPollutant(Optional.ofNullable(response.getData().getDominentpol()).orElse("unknown"));

                data.setTemperature(Optional.ofNullable(response.getData().getIaqi())
                        .map(iaqi -> iaqi.getT())
                        .map(t -> t.getV()).orElse(0.0));
                data.setHumidity(Optional.ofNullable(response.getData().getIaqi())
                        .map(iaqi -> iaqi.getH())
                        .map(h -> h.getV()).orElse(0.0));

                String timestamp = Optional.ofNullable(response.getData().getTime())
                        .map(time -> time.getIso())
                        .orElse(OffsetDateTime.now().toString());
                OffsetDateTime offsetDateTime = OffsetDateTime.parse(timestamp);
                LocalDateTime localTimestamp = offsetDateTime.toLocalDateTime();
                data.setTimestamp(localTimestamp);

                repository.save(data);
            }
        }
    }
}
