package org.tcd.cs7ns4.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.tcd.cs7ns4.service.AirQualityService;

@Component
public class ScheduledTasks {

    private final AirQualityService airQualityService;

    public ScheduledTasks(AirQualityService airQualityService) {
        this.airQualityService = airQualityService;
    }

    @Scheduled(fixedRate = 3600000)  // 每小时请求一次
    public void fetchData() {
        airQualityService.fetchDataAndSave();
    }
}
