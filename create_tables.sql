CREATE TABLE AirQuality (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            city_name VARCHAR(255),
                            aqi INT,
                            dominentpol VARCHAR(50),
                            timestamp TIMESTAMP,
                            sync_time TIMESTAMP
);

CREATE TABLE Attribution (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             air_quality_id BIGINT,
                             url VARCHAR(255),
                             name VARCHAR(255),
                             logo VARCHAR(255),
                             FOREIGN KEY (air_quality_id) REFERENCES AirQuality(id)
);

CREATE TABLE Forecast (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          air_quality_id BIGINT,
                          day DATE,
                          avg INT,
                          max INT,
                          min INT,
                          type VARCHAR(50),  -- e.g., 'o3', 'pm10', 'pm25', 'uvi'
                          FOREIGN KEY (air_quality_id) REFERENCES AirQuality(id)
);

CREATE TABLE IAQI (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      air_quality_id BIGINT,
                      iaqi_type VARCHAR(50),  -- e.g., 'pm25', 'no2', etc.
                      value FLOAT,
                      FOREIGN KEY (air_quality_id) REFERENCES AirQuality(id)
);
