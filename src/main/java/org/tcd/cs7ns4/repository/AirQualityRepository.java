package org.tcd.cs7ns4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tcd.cs7ns4.entity.AirQualityData;

import java.util.List;

public interface AirQualityRepository extends JpaRepository<AirQualityData, Long> {
    List<AirQualityData> findByCity(String city);
}
