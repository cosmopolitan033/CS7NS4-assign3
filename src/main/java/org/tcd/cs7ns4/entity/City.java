package org.tcd.cs7ns4.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;
    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<AirQuality> airQualityRecords;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<AirQuality> getAirQualityRecords() {
        return airQualityRecords;
    }

    public void setAirQualityRecords(List<AirQuality> airQualityRecords) {
        this.airQualityRecords = airQualityRecords;
    }
}
