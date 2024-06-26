
package com.mycompany.mariosweatherapp;

import io.swagger.historical_weather_client.model.InlineResponse200;
import com.google.gson.internal.LinkedTreeMap;

import java.util.List;

public class HistoricalWeatherData {
    private CustomCityLocation requestedLocation;
    private LinkedTreeMap<String, List<Object>> hourly = null;
    private LinkedTreeMap<String, List<Object>> daily = null;
    
    HistoricalWeatherData(){} 
    
    HistoricalWeatherData(CustomCityLocation requestedLocation, InlineResponse200 historicalWeatherAPIresponse) {
    
        this.requestedLocation = requestedLocation;
        
        castResponseHourlyToLinkedTreeMap(historicalWeatherAPIresponse.getHourly());
        
        //todo - weather code meaning, help: https://gist.github.com/Oskar1504/c315a059738437ed224e88f81cc45512
        castResponseDailyToLinkedTreeMap(historicalWeatherAPIresponse.getDaily());
    }
    
    public CustomCityLocation getLocationData() {
        return this.requestedLocation;
    }
   
    private void castResponseHourlyToLinkedTreeMap(Object responseHourly) {
        if (responseHourly instanceof LinkedTreeMap) {
            // Cast it to LinkedTreeMap
            this.hourly = (LinkedTreeMap<String, List<Object>>) responseHourly;
            }
    }
    private void castResponseDailyToLinkedTreeMap(Object responseDaily) {
        if (responseDaily instanceof LinkedTreeMap) {
            // Cast it to LinkedTreeMap
            this.daily = (LinkedTreeMap<String, List<Object>>) responseDaily;
        }
    }
    
    //specific hourly keys
    public static enum hourlyParameterDefs {
        time, temperature_2m, weather_code;
    }
    
    public List<Object> getHourly(hourlyParameterDefs parameter) {

        return this.hourly.get(parameter.toString());
    }
}
