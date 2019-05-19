package com.example.demo.service;

import com.example.demo.vo.Datum;
import com.example.demo.vo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {
//    @Autowired
//    private WeatherDataClient weatherDataClient;

    @Autowired
    private DataClient dataClient;


    @Override
    public Datum getDataByCityName(String cityName) {

//        Example example = new Example();
//        example.setCity("龙泉驿");
//        example.setCityEn("longquanyi");
//        example.setCityid("101270102");
//        example.setCountry("中国");
//        example.setCountryEn("China");
//        List<Datum> data = new ArrayList<>();
//        Datum datum = new Datum();
//        datum.setDay("16日20时");
//        // TODO: add property
//        data.add(datum);
//        example.setData(data);
//        example.setUpdateTime("2019-05-16 18:00:00");
        // TODO:改为由天气数据API来提供数据
        Example dataByCityName = dataClient.getDataByCityName(cityName);

        if (dataByCityName != null){
            return dataByCityName.getData().get(0);
        }else {
            return null;
        }
    }
}
