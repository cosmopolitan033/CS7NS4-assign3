package org.tcd.cs7ns4.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class AirQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer aqi;
    private Integer idx;
    private String dominantPollutant;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private Timestamp dataTimestamp;

    @OneToMany(mappedBy = "airQuality", cascade = CascadeType.ALL)
    private List<Pollutant> pollutants;

    @OneToMany(mappedBy = "airQuality", cascade = CascadeType.ALL)
    private List<Forecast> forecasts;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAqi() {
        return aqi;
    }

    public void setAqi(Integer aqi) {
        this.aqi = aqi;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getDominantPollutant() {
        return dominantPollutant;
    }

    public void setDominantPollutant(String dominantPollutant) {
        this.dominantPollutant = dominantPollutant;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Timestamp getDataTimestamp() {
        return dataTimestamp;
    }

    public void setDataTimestamp(Timestamp dataTimestamp) {
        this.dataTimestamp = dataTimestamp;
    }

    public List<Pollutant> getPollutants() {
        return pollutants;
    }

    public void setPollutants(List<Pollutant> pollutants) {
        this.pollutants = pollutants;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}
