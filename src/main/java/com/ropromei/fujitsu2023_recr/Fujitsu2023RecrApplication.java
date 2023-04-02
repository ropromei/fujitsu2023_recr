package com.ropromei.fujitsu2023_recr;

import com.ropromei.fujitsu2023_recr.BLL.WeatherData;
import com.ropromei.fujitsu2023_recr.DAL.WeatherDataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class Fujitsu2023RecrApplication {

	private final WeatherDataRepository weatherDataRepository;

	public Fujitsu2023RecrApplication(WeatherDataRepository weatherDataRepository) {
		this.weatherDataRepository = weatherDataRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Fujitsu2023RecrApplication.class, args);
	}

	@GetMapping("")
	public GreetResponse hello() {
		return new GreetResponse("Hello World!");
	}

	record GreetResponse(String greet) {}

}
