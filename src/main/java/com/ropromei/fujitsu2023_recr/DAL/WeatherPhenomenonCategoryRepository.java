package com.ropromei.fujitsu2023_recr.DAL;

import com.ropromei.fujitsu2023_recr.BLL.WeatherPhenomenon;
import com.ropromei.fujitsu2023_recr.BLL.WeatherPhenomenonCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WeatherPhenomenonCategoryRepository
        extends JpaRepository<WeatherPhenomenonCategory, Long> {
}
