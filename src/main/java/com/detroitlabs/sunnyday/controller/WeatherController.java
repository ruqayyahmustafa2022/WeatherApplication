package com.detroitlabs.sunnyday.controller;

import com.detroitlabs.sunnyday.model.Forecast;
import com.detroitlabs.sunnyday.model.Temperature;
import com.detroitlabs.sunnyday.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DecimalFormat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Controller
public class WeatherController {
    WeatherService weatherService = new WeatherService();

    @ResponseBody //to get a response from a service
    @RequestMapping("/")
    public String displayWeather() {
        Forecast forecast = weatherService.fetchWeatherData();

        Temperature temperature = forecast.getTemperature();
        DecimalFormat df = new DecimalFormat("##");
        //Humidity humidity = forecast.getHumidity();
        int hum = temperature.getHumidity();
        double temp = temperature.getTemp();


        //String tempString = String.valueOf(temperature.getTemp());
        double fahrTemp = 1.8 * (temp - 273) + 32;



/*
        //TODO: change this to a string and see if html will output new line
        //"The current temperature in " + forecast.getName() + " temp: " + fahrTemp
        //   + "Humidity: " + hum + "%.";
        String[] optionsToChoose = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        JFrame jFrame = new JFrame();
        JComboBox<String> jComboBox = new JComboBox<>(optionsToChoose);
        jComboBox.setBounds(80, 50, 140, 20);

        JButton jButton = new JButton("Done");
        jButton.setBounds(100, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);

        jFrame.add(jButton);
        jFrame.add(jComboBox);
        jFrame.add(jLabel);

        jFrame.setLayout(null);
        jFrame.setSize(350, 250);
        jFrame.setVisible(true);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonth = "You selected" + jComboBox.getItemAt(jComboBox.getSelectedIndex());
                jLabel.setText(selectedMonth);
            }
        });
        */
        return "The current temperature in " + forecast.getName() + " temp: " + df.format(fahrTemp) + "F. "
               + "Humidity: " + hum + "%.";

    }
}
