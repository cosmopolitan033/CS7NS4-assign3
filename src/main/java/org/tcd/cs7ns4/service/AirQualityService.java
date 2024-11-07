package org.tcd.cs7ns4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tcd.cs7ns4.dto.AirQualityApiResponse;
import org.tcd.cs7ns4.entity.AirQuality;
import org.tcd.cs7ns4.entity.City;
import org.tcd.cs7ns4.entity.Pollutant;
import org.tcd.cs7ns4.entity.Forecast;
import org.tcd.cs7ns4.repository.AirQualityRepository;

@Service
public class AirQualityService {

    private final AirQualityRepository airQualityRepository;
    private final RestTemplate restTemplate;

    private static final String API_URL = "https://api.waqi.info/feed/dublin/?token=904517629a36337ba97a3f46eb5f2751b64dea04";

    @Autowired
    public AirQualityService(AirQualityRepository airQualityRepository, RestTemplate restTemplate) {
        this.airQualityRepository = airQualityRepository;
        this.restTemplate = restTemplate;
    }

    public AirQuality fetchAndSaveAirQualityData() {
        // 从API获取数据
        AirQualityApiResponse response = restTemplate.getForObject(API_URL, AirQualityApiResponse.class);

        if (response != null && "ok".equals(response.getStatus())) {
            // 将API数据转换为AirQuality实体
            AirQuality airQuality = mapApiResponseToEntity(response.getData());

            // 保存到数据库
            return airQualityRepository.save(airQuality);
        } else {
            throw new RuntimeException("Failed to fetch data from API");
        }
    }

    private AirQuality mapApiResponseToEntity(AirQualityApiResponse.Data data) {
        // 将API数据映射为实体对象
        AirQuality airQuality = new AirQuality();
        airQuality.setAqi(data.getAqi());
        airQuality.setDominantPollutant(data.getDominentpol());

        City city = new City();
        city.setName(data.getCity().getName());
        city.setGeo(data.getCity().getGeo());
        airQuality.setCity(city);

        // 设置主要污染物
        Pollutant pm25 = new Pollutant("pm25", data.getIaqi().getPm25().getV());
        airQuality.getPollutants().add(pm25);

        // 设置预报
        for (AirQualityApiResponse.Data.ForecastData forecastData : data.getForecast().getDaily().get("pm25")) {
            Forecast forecast = new Forecast();
            forecast.setDay(forecastData.getDay());
            forecast.setAvg(forecastData.getAvg());
            forecast.setMin(forecastData.getMin());
            forecast.setMax(forecastData.getMax());
            airQuality.getForecasts().add(forecast);
        }

        return airQuality;
    }
}
