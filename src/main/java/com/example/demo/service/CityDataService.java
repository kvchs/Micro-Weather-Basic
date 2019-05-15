package com.example.demo.service;

import com.example.demo.vo.City;

import java.io.IOException;
import java.util.List;

public interface CityDataService {

    List<City> listCity() throws IOException;
}
