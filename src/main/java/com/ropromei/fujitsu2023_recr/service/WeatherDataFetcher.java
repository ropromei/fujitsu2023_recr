package com.ropromei.fujitsu2023_recr.service;

import com.ropromei.fujitsu2023_recr.BLL.WeatherData;
import com.ropromei.fujitsu2023_recr.BLL.WeatherPhenomenon;
import com.ropromei.fujitsu2023_recr.BLL.WeatherStation;
import com.ropromei.fujitsu2023_recr.DAL.WeatherDataRepository;
import com.ropromei.fujitsu2023_recr.DAL.WeatherPhenomenonRepository;
import com.ropromei.fujitsu2023_recr.DAL.WeatherStationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Configuration()
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
public class WeatherDataFetcher {
    private WeatherStationRepository weatherStationRepository;
    private WeatherPhenomenonRepository weatherPhenomenonRepository;
    private WeatherDataRepository weatherDataRepository;

    public WeatherDataFetcher(
            WeatherStationRepository weatherStationRepository,
            WeatherPhenomenonRepository weatherPhenomenonRepository,
            WeatherDataRepository weatherDataRepository) {
        this.weatherStationRepository = weatherStationRepository;
        this.weatherPhenomenonRepository = weatherPhenomenonRepository;
        this.weatherDataRepository = weatherDataRepository;
    }

    @Scheduled(cron = "0 15 * * * *")
//    @Scheduled(fixedDelay = 12 * 1000)
    public void fetchWeatherData()
            throws ParserConfigurationException, IOException, SAXException {
        List<WeatherStation> weatherStations = weatherStationRepository.findAll();
        List<WeatherPhenomenon> weatherPhenomena = weatherPhenomenonRepository.findAll();

        DocumentBuilder dbf = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        var doc = dbf.parse(new URL("https://www.ilmateenistus.ee/ilma_andmed/xml/observations.php").openStream());
        doc.getDocumentElement().normalize();

        Timestamp timestamp = Timestamp.from(Instant.now());

        var stations = doc.getElementsByTagName("station");
        List<WeatherData> weatherData = new LinkedList<>();

        for (int i = 0; i < stations.getLength(); i++) {
            var name = stations.item(i).getChildNodes().item(1);
            WeatherStation matchingWeatherStation = null;
            matchingWeatherStation = weatherStations.stream()
                    .filter(weatherStation -> weatherStation.getName().equals(name.getTextContent()))
                    .findFirst()
                    .orElse(null);
            if (matchingWeatherStation == null) {
                continue;
            }

            Float temperature = Float.parseFloat(stations.item(i).getChildNodes().item(19).getTextContent());
            Float windSpeed = Float.parseFloat(stations.item(i).getChildNodes().item(23).getTextContent());
            var weatherPhenomenonName = stations.item(i).getChildNodes().item(9).getTextContent();
            WeatherPhenomenon weatherPhenomenon = weatherPhenomena.stream()
                    .filter(weatherPhenomenon1 -> weatherPhenomenon1.getName().equals(weatherPhenomenonName))
                    .findFirst().orElse(null);

            weatherData.add(new WeatherData(matchingWeatherStation, temperature, windSpeed, weatherPhenomenon, timestamp));
        }

        weatherDataRepository.saveAll(weatherData);
    }
}
