package com.ropromei.fujitsu2023_recr.DAL.config;

import com.ropromei.fujitsu2023_recr.BLL.WeatherPhenomenonCategory;
import com.ropromei.fujitsu2023_recr.DAL.WeatherPhenomenonCategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class WeatherPhenomenonCategoryConfig {
    @Bean
    CommandLineRunner weatherPhenomenonCategoryCommandLineRunner(WeatherPhenomenonCategoryRepository weatherPhenomenonCategoryRepository) {
        return args -> {
            List<WeatherPhenomenonCategory> weatherPhenomenonCategories = new LinkedList<>();

            weatherPhenomenonCategories.add(new WeatherPhenomenonCategory("snow"));
            weatherPhenomenonCategories.add(new WeatherPhenomenonCategory("sleet"));
            weatherPhenomenonCategories.add(new WeatherPhenomenonCategory("rain"));
            weatherPhenomenonCategories.add(new WeatherPhenomenonCategory("glaze"));
            weatherPhenomenonCategories.add(new WeatherPhenomenonCategory("hail"));
            weatherPhenomenonCategories.add(new WeatherPhenomenonCategory("thunder"));

            weatherPhenomenonCategoryRepository.saveAll(weatherPhenomenonCategories);
        };
    }
}
