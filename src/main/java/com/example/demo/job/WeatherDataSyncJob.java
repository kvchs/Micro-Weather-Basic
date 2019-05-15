package com.example.demo.job;

import com.example.demo.service.CityDataService;
import com.example.demo.service.WeatherDataService;
import com.example.demo.vo.City;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;
import java.util.List;


public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("开始同步天气数据");
        logger.info("Weather Data Sync Job");
        List<City> cities = null;
        try {
            cities = cityDataService.listCity();
        } catch (IOException e) {
            logger.error("Exception: ", e);
        }

        for (City city: cities){
            String cityName = city.getCityZh();
            logger.info("Weather Data Sync Job, City Name : " + cityName);
//            weatherDataService.syncDataByCityId(cityId);
            weatherDataService.syncDataByCityName(cityName);
        }
        logger.info("结束同步天气数据");
    }
}
