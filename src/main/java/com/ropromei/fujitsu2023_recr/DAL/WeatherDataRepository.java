package com.ropromei.fujitsu2023_recr.DAL;

import com.ropromei.fujitsu2023_recr.BLL.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeatherDataRepository
        extends JpaRepository<WeatherData, UUID> {
}
