package com.example.demo.controller;

import com.example.demo.service.CityClient;
import com.example.demo.service.DataClient;
import com.example.demo.service.WeatherReportService;
import com.example.demo.vo.City;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {


    @Autowired
    private WeatherReportService weatherReportService;

//    @Autowired
//    private CityClient cityClient;
    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityName/{cityName}")
    public ModelAndView getReportByCityName(@PathVariable("cityName") String cityName, Model model) throws IOException {
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityName", cityName);

        // TODO:改为城市数据API提供
//        model.addAttribute("cityList", cityDataService.listCity());
        List<City> cities = null;

        try {
            cities = dataClient.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("cityList", cities);

        model.addAttribute("report", weatherReportService.getDataByCityName(cityName));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
