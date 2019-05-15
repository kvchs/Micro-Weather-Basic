package com.example.demo.service;

import com.example.demo.vo.Datum;
import com.example.demo.vo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    WeatherDataService weatherDataService;
    @Override
    public Datum getDataByCityName(String cityName) {
        Example dataByCityName = weatherDataService.getDataByCityName(cityName);
        return dataByCityName.getData().get(0);
    }
}
