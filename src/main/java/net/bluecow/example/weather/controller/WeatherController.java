package net.bluecow.example.weather.controller;

import net.bluecow.example.weather.WeatherClient;
import net.bluecow.example.weather.wsdl.GetCityForecastByZIPResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    WeatherClient weatherClient;

    @RequestMapping(value="weather", produces = "application/json")
    public GetCityForecastByZIPResponse getForecast(@RequestParam String zipCode) {
        return weatherClient.getCityForecastByZip(zipCode);
    }
}
