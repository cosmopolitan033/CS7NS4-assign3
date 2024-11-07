package org.tcd.cs7ns4.dto;

import org.apache.el.parser.ParseException;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AirQualityApiResponse {

    private String status;
    private Data data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private int aqi;
        private int idx;
        private List<Attribution> attributions;
        private City city;
        private String dominentpol;
        private Iaqi iaqi;
        private Time time;
        private Forecast forecast;
        private Debug debug;

        // Getters and Setters for all fields


        public int getAqi() {
            return aqi;
        }

        public void setAqi(int aqi) {
            this.aqi = aqi;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public List<Attribution> getAttributions() {
            return attributions;
        }

        public void setAttributions(List<Attribution> attributions) {
            this.attributions = attributions;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public String getDominentpol() {
            return dominentpol;
        }

        public void setDominentpol(String dominentpol) {
            this.dominentpol = dominentpol;
        }

        public Iaqi getIaqi() {
            return iaqi;
        }

        public void setIaqi(Iaqi iaqi) {
            this.iaqi = iaqi;
        }

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public Forecast getForecast() {
            return forecast;
        }

        public void setForecast(Forecast forecast) {
            this.forecast = forecast;
        }

        public Debug getDebug() {
            return debug;
        }

        public void setDebug(Debug debug) {
            this.debug = debug;
        }

        public static class Attribution {
            private String url;
            private String name;
            private String logo;

            // Getters and Setters

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
        }

        public static class City {
            private Double[] geo;
            private String name;
            private String url;
            private String location;

            // Getters and Setters

            public Double[] getGeo() {
                return geo;
            }

            public void setGeo(Double[] geo) {
                this.geo = geo;
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

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }
        }

        public static class Iaqi {
            private Pollutant h;
            private Pollutant no2;
            private Pollutant o3;
            private Pollutant p;
            private Pollutant pm10;
            private Pollutant pm25;
            private Pollutant t;
            private Pollutant w;
            private Pollutant wg;

            // Getters and Setters for each pollutant

            public Pollutant getH() {
                return h;
            }

            public void setH(Pollutant h) {
                this.h = h;
            }

            public Pollutant getNo2() {
                return no2;
            }

            public void setNo2(Pollutant no2) {
                this.no2 = no2;
            }

            public Pollutant getO3() {
                return o3;
            }

            public void setO3(Pollutant o3) {
                this.o3 = o3;
            }

            public Pollutant getP() {
                return p;
            }

            public void setP(Pollutant p) {
                this.p = p;
            }

            public Pollutant getPm10() {
                return pm10;
            }

            public void setPm10(Pollutant pm10) {
                this.pm10 = pm10;
            }

            public Pollutant getPm25() {
                return pm25;
            }

            public void setPm25(Pollutant pm25) {
                this.pm25 = pm25;
            }

            public Pollutant getT() {
                return t;
            }

            public void setT(Pollutant t) {
                this.t = t;
            }

            public Pollutant getW() {
                return w;
            }

            public void setW(Pollutant w) {
                this.w = w;
            }

            public Pollutant getWg() {
                return wg;
            }

            public void setWg(Pollutant wg) {
                this.wg = wg;
            }
        }

        public static class Pollutant {
            private double v;

            public double getV() {
                return v;
            }

            public void setV(double v) {
                this.v = v;
            }
        }

        public static class Time {
            private String s;
            private String tz;
            private long v;
            private String iso;

            // Getters and Setters

            public String getS() {
                return s;
            }

            public void setS(String s) {
                this.s = s;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }

            public long getV() {
                return v;
            }

            public void setV(long v) {
                this.v = v;
            }

            public String getIso() {
                return iso;
            }

            public void setIso(String iso) {
                this.iso = iso;
            }
        }

        public static class Forecast {
            private Map<String, List<ForecastData>> daily;

            // Getters and Setters

            public Map<String, List<ForecastData>> getDaily() {
                return daily;
            }

            public void setDaily(Map<String, List<ForecastData>> daily) {
                this.daily = daily;
            }
        }

        public static class ForecastData {
            private int avg;
            private String day;
            private int max;
            private int min;
            private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Getters and Setters

            public double getAvg() {
                return avg;
            }

            public void setAvg(int avg) {
                this.avg = avg;
            }

            public Date getDay() {
                try {
                    return day != null ? dateFormat.parse(day) : null;
                } catch (java.text.ParseException e) {
                    return null;
                }
            }

            public void setDay(String day) {
                this.day = day;
            }

            public double getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class Debug {
            private String sync;

            // Getters and Setters

            public String getSync() {
                return sync;
            }

            public void setSync(String sync) {
                this.sync = sync;
            }
        }
    }
}
