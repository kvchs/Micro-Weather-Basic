package com.example.demo.service;

import com.example.demo.vo.City;
import com.example.demo.vo.Datum;
import com.example.demo.vo.Example;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msa-weather-eureka-client-zuul", fallback = DataClientFallback.class)
public interface DataClient {

    /**
     * 获取城市列表
     * @returne
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityName/{cityName}")
    Example getDataByCityName(@PathVariable("cityName") String cityName);

}
