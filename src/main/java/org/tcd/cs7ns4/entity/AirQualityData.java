package org.tcd.cs7ns4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
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

}
