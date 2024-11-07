package org.tcd.cs7ns4.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AirQualityData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private Integer aqi;
    private String dominantPollutant;
    private Double temperature;
    private Double humidity;
    private LocalDateTime timestamp;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public String getDominantPollutant() {
        return dominantPollutant;
    }

    public void setDominantPollutant(String dominantPollutant) {
        this.dominantPollutant = dominantPollutant;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
