package com.detroitlabs.sunnyday.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)   //tells jackson to map from response object to class any props that
                                                // we don't have values, ignore

public class Forecast {
    String name;
    Temperature temperature;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @JsonProperty("main")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("main")
    public Temperature getTemperature(){
        return temperature;
    }


}
