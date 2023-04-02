package com.ropromei.fujitsu2023_recr.BLL;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @UuidGenerator
    private UUID weatherDataId;
    @ManyToOne
    @JoinColumn(name = "weather_station_id")
    private WeatherStation weatherStation;
    private float airTemperature;
    private float windSpeed;
    @ManyToOne
    @JoinColumn(name = "weather_phenomenon_id")
    private WeatherPhenomenon weatherPhenomenon;
    private Timestamp timestamp;

    public WeatherData(
            UUID weatherDataId,
            WeatherStation weatherStation,
            float airTemperature,
            float windSpeed,
            WeatherPhenomenon weatherPhenomenon,
            Timestamp timestamp) {
        this.weatherDataId = weatherDataId;
        this.weatherStation = weatherStation;
        this.airTemperature = airTemperature;
        this.windSpeed = windSpeed;
        this.weatherPhenomenon = weatherPhenomenon;
        this.timestamp = timestamp;
    }

    public WeatherData(
            WeatherStation weatherStation,
            float airTemperature,
            float windSpeed,
            WeatherPhenomenon weatherPhenomenon,
            Timestamp timestamp) {
        this.weatherStation = weatherStation;
        this.airTemperature = airTemperature;
        this.windSpeed = windSpeed;
        this.weatherPhenomenon = weatherPhenomenon;
        this.timestamp = timestamp;
    }

    public WeatherData() {
    }

    public UUID getWeatherDataId() {
        return weatherDataId;
    }

    public void setWeatherDataId(UUID weatherDataId) {
        this.weatherDataId = weatherDataId;
    }

    public WeatherStation getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    public float getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(float airTemperature) {
        this.airTemperature = airTemperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public WeatherPhenomenon getWeatherPhenomenon() {
        return weatherPhenomenon;
    }

    public void setWeatherPhenomenon(WeatherPhenomenon weatherPhenomenon) {
        this.weatherPhenomenon = weatherPhenomenon;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherData that = (WeatherData) o;
        return Float.compare(that.airTemperature, airTemperature) == 0 && Float.compare(that.windSpeed, windSpeed) == 0 && Objects.equals(weatherDataId, that.weatherDataId) && Objects.equals(weatherStation, that.weatherStation) && Objects.equals(weatherPhenomenon, that.weatherPhenomenon) && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherDataId, weatherStation, airTemperature, windSpeed, weatherPhenomenon, timestamp);
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "weatherDataId=" + weatherDataId +
                ", weatherStation=" + weatherStation +
                ", airTemperature=" + airTemperature +
                ", windSpeed=" + windSpeed +
                ", weatherPhenomenon=" + weatherPhenomenon +
                ", timestamp=" + timestamp +
                '}';
    }
}
