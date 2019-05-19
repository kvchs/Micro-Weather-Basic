package com.example.demo.service;

import com.example.demo.vo.City;
import com.example.demo.vo.Example;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("micro-weather-data-eureka")
public interface WeatherDataClient {

    @GetMapping("/weather/cityName/{cityName}")
    Example getDataByCityName(@PathVariable("cityName") String cityName);


}
