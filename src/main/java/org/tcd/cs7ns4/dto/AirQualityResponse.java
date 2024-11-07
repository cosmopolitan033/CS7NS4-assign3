package org.tcd.cs7ns4.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AirQualityResponse {
    private String status;
    private Data data;

    @Getter
    @Setter
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

        @Getter
        @Setter
        public static class Attribution {
            private String url;
            private String name;
        }

        @Getter
        @Setter
        public static class City {
            private List<Double> geo;
            private String name;
            private String url;
            private String location;
        }

        @Getter
        @Setter
        public static class Iaqi {
            private Value co;
            private Value h;
            private Value no2;
            private Value o3;
            private Value p;
            private Value pm10;
            private Value pm25;
            private Value so2;
            private Value t;
            private Value w;

            @Getter
            @Setter
            public static class Value {
                private double v;
            }
        }

        @Getter
        @Setter
        public static class Time {
            private String s;
            private String tz;
            private long v;
            private String iso;
        }

        @Getter
        @Setter
        public static class Forecast {
            private Daily daily;

            @Getter
            @Setter
            public static class Daily {
                private List<ForecastData> o3;
                private List<ForecastData> pm10;
                private List<ForecastData> pm25;
                private List<ForecastData> uvi;

                @Getter
                @Setter
                public static class ForecastData {
                    private int avg;
                    private String day;
                    private int max;
                    private int min;
                }
            }
        }

        @Getter
        @Setter
        public static class Debug {
            private String sync;
        }
    }
}
