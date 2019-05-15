package com.example.demo.service;

import com.example.demo.vo.Example;


public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     * @param cityId
     * @return
     */
    Example getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    Example getDataByCityName(String cityName);

    /**
     * 根据城市ID同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);

    void syncDataByCityName(String cityName);


}
