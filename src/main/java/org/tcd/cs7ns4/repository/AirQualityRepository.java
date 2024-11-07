package org.tcd.cs7ns4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tcd.cs7ns4.entity.AirQuality;

@Repository
public interface AirQualityRepository extends JpaRepository<AirQuality, Long> {
    // 如果需要自定义查询，可以在此处定义方法
}
