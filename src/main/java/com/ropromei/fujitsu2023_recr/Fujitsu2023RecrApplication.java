package com.ropromei.fujitsu2023_recr;

import com.ropromei.fujitsu2023_recr.BLL.WeatherData;
import com.ropromei.fujitsu2023_recr.DAL.WeatherDataRepository;
import com.ropromei.fujitsu2023_recr.DAL.WeatherStationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class Fujitsu2023RecrApplication {

	private final WeatherDataRepository weatherDataRepository;
	private final WeatherStationRepository weatherStationRepository;

	public Fujitsu2023RecrApplication(WeatherDataRepository weatherDataRepository,
									  WeatherStationRepository weatherStationRepository) {
		this.weatherDataRepository = weatherDataRepository;
		this.weatherStationRepository = weatherStationRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Fujitsu2023RecrApplication.class, args);
	}

	@GetMapping("")
	public GreetResponse hello() {
		return new GreetResponse("Hello World!");
	}

	@GetMapping("/weather")
	public List<WeatherData> getWeatherData() {
		long weatherStationsCount = weatherStationRepository.count();
		return weatherDataRepository
				.findAll(Sort.by(Sort.Direction.DESC, "timestamp"))
				.stream()
				.limit(weatherStationsCount)
				.toList();
	}

	record GreetResponse(String greet) {}

}
