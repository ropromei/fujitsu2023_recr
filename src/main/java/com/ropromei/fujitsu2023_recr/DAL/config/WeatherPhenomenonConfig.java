package com.ropromei.fujitsu2023_recr.DAL.config;

import com.ropromei.fujitsu2023_recr.BLL.WeatherPhenomenon;
import com.ropromei.fujitsu2023_recr.BLL.WeatherPhenomenonCategory;
import com.ropromei.fujitsu2023_recr.DAL.WeatherPhenomenonCategoryRepository;
import com.ropromei.fujitsu2023_recr.DAL.WeatherPhenomenonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Configuration
public class WeatherPhenomenonConfig {
    @Bean
    CommandLineRunner weatherPhenomenonCommandLineRunner(
            WeatherPhenomenonRepository weatherPhenomenonRepository,
            WeatherPhenomenonCategoryRepository categoryRepository) {
        return args -> {
            List<WeatherPhenomenon> weatherPhenomenonList = new LinkedList<>();
            WeatherPhenomenonCategory snow = categoryRepository.findById(1L).get();
            WeatherPhenomenonCategory sleet = categoryRepository.findById(2L).get();
            WeatherPhenomenonCategory rain = categoryRepository.findById(3L).get();
            WeatherPhenomenonCategory glaze = categoryRepository.findById(4L).get();
            WeatherPhenomenonCategory hail = categoryRepository.findById(5L).get();
            WeatherPhenomenonCategory thunder = categoryRepository.findById(6L).get();

            weatherPhenomenonList.add(new WeatherPhenomenon("Clear"));
            weatherPhenomenonList.add(new WeatherPhenomenon("Few clouds"));
            weatherPhenomenonList.add(new WeatherPhenomenon("Variable clouds"));
            weatherPhenomenonList.add(new WeatherPhenomenon("Cloudy with clear spells"));
            weatherPhenomenonList.add(new WeatherPhenomenon("Overcast"));
            weatherPhenomenonList.add(new WeatherPhenomenon("Light snow shower", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Moderate snow shower", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Heavy snow shower", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Light shower", rain));
            weatherPhenomenonList.add(new WeatherPhenomenon("Moderate shower", rain));
            weatherPhenomenonList.add(new WeatherPhenomenon("Heavy shower", rain));
            weatherPhenomenonList.add(new WeatherPhenomenon("Light rain", rain));
            weatherPhenomenonList.add(new WeatherPhenomenon("Moderate rain", rain));
            weatherPhenomenonList.add(new WeatherPhenomenon("Heavy rain", rain));
            weatherPhenomenonList.add(new WeatherPhenomenon("Glaze", glaze));
            weatherPhenomenonList.add(new WeatherPhenomenon("Light sleet", sleet));
            weatherPhenomenonList.add(new WeatherPhenomenon("Moderate sleet", sleet));
            weatherPhenomenonList.add(new WeatherPhenomenon("Light snowfall", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Moderate snowfall", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Heavy snowfall", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Blowing snow", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Drifting snow", snow));
            weatherPhenomenonList.add(new WeatherPhenomenon("Hail", hail));
            weatherPhenomenonList.add(new WeatherPhenomenon("Mist"));
            weatherPhenomenonList.add(new WeatherPhenomenon("Fog"));
            weatherPhenomenonList.add(new WeatherPhenomenon("Thunder", thunder));
            weatherPhenomenonList.add(new WeatherPhenomenon("Thunderstorm", thunder));

            weatherPhenomenonRepository.saveAll(weatherPhenomenonList);
        };
    }
}
