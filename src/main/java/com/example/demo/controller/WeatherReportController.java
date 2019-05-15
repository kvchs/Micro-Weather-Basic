package com.example.demo.controller;

import com.example.demo.service.CityDataService;
import com.example.demo.service.WeatherDataService;
import com.example.demo.service.WeatherReportService;
import com.example.demo.vo.Datum;
import com.example.demo.vo.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherReportService weatherReportService;


    @GetMapping("/cityName/{cityName}")
    public ModelAndView getReportByCityName(@PathVariable("cityName") String cityName, Model model) throws IOException {
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityName", cityName);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityName(cityName));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
