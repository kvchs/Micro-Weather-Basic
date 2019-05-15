package com.example.demo.service;

import com.example.demo.vo.Example;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * https://www.tianqiapi.com/api/?cityid=101270102
 */

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String DOMAIN = "https://www.tianqiapi.com/api";
    private static final Long TIME_OUT = 1800L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Example getDataByCityId(String cityId) {

        //101270101
        String uri = DOMAIN + "?cityid=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public Example getDataByCityName(String cityName) {
        // 成都
        String uri = DOMAIN + "?city=" + cityName;
        return doGetWeather(uri);
    }


    private Example doGetWeather(String uri) {

        /**
         * 先查询缓存，缓存中有的话取缓存中的数据
         * 没有，则调用服务接口来获取
         */
        String key = uri;
        String body = null;

        ObjectMapper mapper = new ObjectMapper();
        Example weatherResponse = null;

        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();

        if (stringRedisTemplate.hasKey(key)) {
            logger.info("Redis has data");
            body = opsForValue.get(key);
        } else {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

            if (responseEntity.getStatusCodeValue() == 200) {
                body = responseEntity.getBody();
            }

            // 调用之后把数据写入缓存中
            logger.info("Redis not data, So request the three server");
            opsForValue.set(key, body, TIME_OUT, TimeUnit.SECONDS);
        }

        try {
            weatherResponse = mapper.readValue(body, Example.class);
        } catch (JsonParseException e) {
            logger.error("Error : ", e);
        } catch (JsonMappingException e) {
            logger.error("Error : ", e);
        } catch (IOException e) {
            logger.error("Error : ", e);
        }

        return weatherResponse;
    }


    @Override
    public void syncDataByCityId(String cityId) {
        String uri = DOMAIN + "?cityId=" + cityId;
        saveWeatherData(uri);

    }

    @Override
    public void syncDataByCityName(String cityName) {
        String uri = DOMAIN + "?cityName=" + cityName;
        saveWeatherData(uri);
    }

    /**
     * 把天气数据放入缓存
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String key = uri;
        String body = null;

        ObjectMapper mapper = new ObjectMapper();
        Example weatherResponse = null;

        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        if (responseEntity.getStatusCodeValue() == 200) {
            body = responseEntity.getBody();
        }

        opsForValue.set(key, body, TIME_OUT, TimeUnit.SECONDS);

    }
}
