package com.ropromei.fujitsu2023_recr.DAL;

import com.ropromei.fujitsu2023_recr.BLL.WeatherPhenomenon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeatherPhenomenonRepository
        extends JpaRepository<WeatherPhenomenon, Long> {
}
