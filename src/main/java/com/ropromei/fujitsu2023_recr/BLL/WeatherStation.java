package com.ropromei.fujitsu2023_recr.BLL;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class WeatherStation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long weatherStationId;
    private String name;
    private String wmoCode;
    @OneToMany(mappedBy = "weatherStation")
    private Set<WeatherData> weatherDataSet;

    public WeatherStation(long weatherStationId, String name, String wmoCode) {
        this.weatherStationId = weatherStationId;
        this.name = name;
        this.wmoCode = wmoCode;
    }

    public WeatherStation(String name, String wmoCode) {
        this.name = name;
        this.wmoCode = wmoCode;
    }

    public WeatherStation() {
    }

    public long getWeatherStationId() {
        return weatherStationId;
    }

    public void setWeatherStationId(long weatherStationId) {
        this.weatherStationId = weatherStationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWmoCode() {
        return wmoCode;
    }

    public void setWmoCode(String wmoCode) {
        this.wmoCode = wmoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherStation that = (WeatherStation) o;
        return Objects.equals(weatherStationId, that.weatherStationId) && Objects.equals(name, that.name) && Objects.equals(wmoCode, that.wmoCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherStationId, name, wmoCode);
    }

    @Override
    public String toString() {
        return "WeatherStation{" +
                "weatherStationId=" + weatherStationId +
                ", name='" + name + '\'' +
                ", wmoCode='" + wmoCode + '\'' +
                '}';
    }
}
