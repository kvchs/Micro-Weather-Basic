package com.example.demo.service;

import com.example.demo.vo.Datum;
import com.example.demo.vo.Weather;

import java.util.List;

public interface WeatherReportService {
    /**
     * 根据城市名称查询天气信息
     * @param cityName
     * @return
     */
    Datum getDataByCityName(String cityName);
}
