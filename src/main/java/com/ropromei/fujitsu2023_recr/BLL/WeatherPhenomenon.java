package com.ropromei.fujitsu2023_recr.BLL;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class WeatherPhenomenon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long weatherPhenomenonId;
    @Column(unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name="weather_phenomenon_category_id")
    private WeatherPhenomenonCategory weatherPhenomenonCategory;
    @OneToMany(mappedBy = "weatherPhenomenon")
    private Set<WeatherData> weatherDataSet;

    public WeatherPhenomenon(long weatherPhenomenonId, String name, WeatherPhenomenonCategory weatherPhenomenonCategory) {
        this.weatherPhenomenonId = weatherPhenomenonId;
        this.name = name;
        this.weatherPhenomenonCategory = weatherPhenomenonCategory;
    }

    public WeatherPhenomenon(long weatherPhenomenonId, String name) {
        this.weatherPhenomenonId = weatherPhenomenonId;
        this.name = name;
    }

    public WeatherPhenomenon(String name, WeatherPhenomenonCategory weatherPhenomenonCategory) {
        this.name = name;
        this.weatherPhenomenonCategory = weatherPhenomenonCategory;
    }

    public WeatherPhenomenon(String name) {
        this.name = name;
    }

    public WeatherPhenomenon() {
    }

    public long getWeatherPhenomenonId() {
        return weatherPhenomenonId;
    }

    public void setWeatherPhenomenonId(long weatherPhenomenonId) {
        this.weatherPhenomenonId = weatherPhenomenonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeatherPhenomenonCategory getWeatherPhenomenonCategory() {
        return weatherPhenomenonCategory;
    }

    public void setWeatherPhenomenonCategory(WeatherPhenomenonCategory weatherPhenomenonCategory) {
        this.weatherPhenomenonCategory = weatherPhenomenonCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherPhenomenon that = (WeatherPhenomenon) o;
        return weatherPhenomenonId == that.weatherPhenomenonId && Objects.equals(name, that.name) && Objects.equals(weatherPhenomenonCategory, that.weatherPhenomenonCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherPhenomenonId, name, weatherPhenomenonCategory);
    }

    @Override
    public String toString() {
        return "WeatherPhenomenon{" +
                "weatherPhenomenonId=" + weatherPhenomenonId +
                ", name='" + name + '\'' +
                ", weatherPhenomenonCategory=" + weatherPhenomenonCategory +
                '}';
    }
}
