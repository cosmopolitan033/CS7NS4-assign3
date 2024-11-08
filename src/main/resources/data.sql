CREATE TABLE air_quality_data (
                                id SERIAL PRIMARY KEY,
                                city VARCHAR(255),
                                aqi INTEGER,
                                idx INTEGER,
                                dominant_pollutant VARCHAR(50),
                                temperature DOUBLE PRECISION,
                                humidity DOUBLE PRECISION,
                                timestamp TIMESTAMP
);

CREATE TABLE sensor_data (
                             id SERIAL PRIMARY KEY,
                             serial VARCHAR(50),
                             type VARCHAR(50),
                             datetime TIMESTAMP,
                             data JSONB,
                             outlier_flag VARCHAR(3)
);
