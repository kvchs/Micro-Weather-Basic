package com.example.demo.service;

import com.example.demo.util.JsonBuilder;
import com.example.demo.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    private final Logger logger = LoggerFactory.getLogger(CityDataServiceImpl.class);
    @Override
    public List<City> listCity() throws IOException {

        // 读取Json字符串
        Resource resource = new ClassPathResource("city.json");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            buffer.append(line);
        }
        bufferedReader.close();
//        logger.info(buffer.toString());
        List<City> cityList = (List<City>)JsonBuilder.jsonStringToCityList(buffer.toString());
        // Json字符串转换为对象
        return cityList;
    }
}
