package com.example.demo.service;

import com.example.demo.vo.City;
import com.example.demo.vo.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient{
    @Override
    public List<City> listCity() throws Exception {
        List<City> cities = new ArrayList<>();
        City city = new City();
        city.setCityEn("北京");
        cities.add(city);
        return cities;
    }

    @Override
    public Example getDataByCityName(String cityName) {
        return null;
    }
}
