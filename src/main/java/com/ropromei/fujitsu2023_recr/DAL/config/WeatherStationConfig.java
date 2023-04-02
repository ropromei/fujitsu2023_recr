package com.ropromei.fujitsu2023_recr.DAL.config;

import com.ropromei.fujitsu2023_recr.BLL.WeatherStation;
import com.ropromei.fujitsu2023_recr.DAL.WeatherStationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class WeatherStationConfig {
    @Bean
    CommandLineRunner weatherStationCommandLineRunner(WeatherStationRepository weatherStationRepository) {
        return args -> {
            List<WeatherStation> weatherStations = new LinkedList<>();

            weatherStations.add(new WeatherStation("Tallinn-Harku", "26038"));
            weatherStations.add(new WeatherStation("Tartu-Tõravere", "26242"));
            weatherStations.add(new WeatherStation("Pärnu", "41803"));

            weatherStationRepository.saveAll(weatherStations);
        };
    }
}
