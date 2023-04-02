package com.ropromei.fujitsu2023_recr.DAL;

import com.ropromei.fujitsu2023_recr.BLL.WeatherStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeatherStationRepository
        extends JpaRepository<WeatherStation, Long> {
}
