package com.detroitlabs.sunnyday.service;

import com.detroitlabs.sunnyday.model.Forecast;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    public Forecast fetchWeatherData(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                "http://api.openweathermap.org/data/2.5/weather?q=Detroit&APPID=89c9a6c0a5938112be141aa8997d67ce", Forecast.class);

    }
}
