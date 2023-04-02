package com.ropromei.fujitsu2023_recr.BLL;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.*;


@Entity
public class WeatherPhenomenonCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long weatherPhenomenonCategoryId;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "weatherPhenomenonCategory")
    private Set<WeatherPhenomenon> weatherPhenomena;

    public WeatherPhenomenonCategory(long weatherPhenomenonCategoryId, String name) {
        this.weatherPhenomenonCategoryId = weatherPhenomenonCategoryId;
        this.name = name;
    }

    public WeatherPhenomenonCategory(String name) {
        this.name = name;
    }

    public WeatherPhenomenonCategory() {
    }

    public long getWeatherPhenomenonCategoryId() {
        return weatherPhenomenonCategoryId;
    }

    public void setWeatherPhenomenonCategoryId(long weatherPhenomenonCategoryId) {
        this.weatherPhenomenonCategoryId = weatherPhenomenonCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<WeatherPhenomenon> getWeatherPhenomena() {
        return weatherPhenomena;
    }

    public void setWeatherPhenomena(Set<WeatherPhenomenon> weatherPhenomena) {
        this.weatherPhenomena = weatherPhenomena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherPhenomenonCategory that = (WeatherPhenomenonCategory) o;
        return Objects.equals(weatherPhenomenonCategoryId, that.weatherPhenomenonCategoryId) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weatherPhenomenonCategoryId, name);
    }

    @Override
    public String toString() {
        return "WeatherPhenomenonCategory{" +
                "weatherPhenomenonCategoryId=" + weatherPhenomenonCategoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
