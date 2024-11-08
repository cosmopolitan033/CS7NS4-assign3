CREATE TABLE AirQualityData (
                                id SERIAL PRIMARY KEY,
                                city VARCHAR(255),
                                aqi INTEGER,
                                idx INTEGER,
                                dominant_pollutant VARCHAR(50),
                                temperature DOUBLE PRECISION,
                                humidity DOUBLE PRECISION,
                                timestamp TIMESTAMP
);

CREATE TABLE Attribution (
                             id SERIAL PRIMARY KEY,
                             air_quality_data_id INTEGER REFERENCES AirQualityData(id) ON DELETE CASCADE,
                             url VARCHAR(255),
                             name VARCHAR(255)
);

CREATE TABLE City (
                      id SERIAL PRIMARY KEY,
                      air_quality_data_id INTEGER REFERENCES AirQualityData(id) ON DELETE CASCADE,
                      name VARCHAR(255),
                      url VARCHAR(255),
                      location VARCHAR(255)
);

CREATE TABLE CityGeo (
                         id SERIAL PRIMARY KEY,
                         city_id INTEGER REFERENCES City(id) ON DELETE CASCADE,
                         latitude DOUBLE PRECISION,
                         longitude DOUBLE PRECISION
);

CREATE TABLE Iaqi (
                      id SERIAL PRIMARY KEY,
                      air_quality_data_id INTEGER REFERENCES AirQualityData(id) ON DELETE CASCADE,
                      co DOUBLE PRECISION,
                      h DOUBLE PRECISION,
                      no2 DOUBLE PRECISION,
                      o3 DOUBLE PRECISION,
                      p DOUBLE PRECISION,
                      pm10 DOUBLE PRECISION,
                      pm25 DOUBLE PRECISION,
                      so2 DOUBLE PRECISION,
                      t DOUBLE PRECISION,
                      w DOUBLE PRECISION
);

CREATE TABLE Forecast (
                          id SERIAL PRIMARY KEY,
                          air_quality_data_id INTEGER REFERENCES AirQualityData(id) ON DELETE CASCADE
);

CREATE TABLE ForecastData (
                              id SERIAL PRIMARY KEY,
                              forecast_id INTEGER REFERENCES Forecast(id) ON DELETE CASCADE,
                              pollutant_type VARCHAR(10),
                              avg INTEGER,
                              day DATE,
                              max INTEGER,
                              min INTEGER
);

CREATE TABLE Debug (
                       id SERIAL PRIMARY KEY,
                       air_quality_data_id INTEGER REFERENCES AirQualityData(id) ON DELETE CASCADE,
                       sync TIMESTAMP
);

CREATE TABLE TimeData (
                          id SERIAL PRIMARY KEY,
                          air_quality_data_id INTEGER REFERENCES AirQualityData(id) ON DELETE CASCADE,
                          s TIMESTAMP,
                          tz VARCHAR(10),
                          v BIGINT,
                          iso TIMESTAMP
);
