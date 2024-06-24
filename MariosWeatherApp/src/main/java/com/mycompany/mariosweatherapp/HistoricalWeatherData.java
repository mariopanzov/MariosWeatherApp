
package com.mycompany.mariosweatherapp;

import io.swagger.client.model.InlineResponse200;
import com.google.gson.internal.LinkedTreeMap;

import java.util.List;

public class HistoricalWeatherData {
    private CustomCityLocation requestedLocation;
    private LinkedTreeMap<String, List<Object>> hourly = null;
    private LinkedTreeMap<String, List<Object>> daily = null;
    
    HistoricalWeatherData(){} 
    
    HistoricalWeatherData(CustomCityLocation requestedLocation, InlineResponse200 historicalWeatherAPIresponse) {
    
        this.requestedLocation = requestedLocation;
    //this.latitude = historicalWeatherAPIresponse.getLatitude();
    //this.longitude = historicalWeatherAPIresponse.getLongitude();
        castResponseHourlyToLinkedTreeMap(historicalWeatherAPIresponse.getHourly());
        castResponseDailyToLinkedTreeMap(historicalWeatherAPIresponse.getDaily());
    }
   
    private void castResponseHourlyToLinkedTreeMap(Object responseHourly) {
        if (responseHourly instanceof LinkedTreeMap) {
            // Cast it to LinkedTreeMap
            this.hourly = (LinkedTreeMap<String, List<Object>>) responseHourly;
            }
    }
    private void castResponseDailyToLinkedTreeMap(Object responseHourly) {
        if (responseHourly instanceof LinkedTreeMap) {
            // Cast it to LinkedTreeMap
            this.daily = (LinkedTreeMap<String, List<Object>>) responseHourly;
        }
    }
    
    public static enum hourlyParameterDefs {
        time, temperature_2m, weather_code;
    }
    
    public List<Object> getHourly(hourlyParameterDefs parameter) {
        
        //List<> temp = this.hourly.get(parameter.toString());
               
        for(Object a : this.hourly.get(parameter.toString())){
            System.out.println(a);
        }
        /*for(String key : hourly.keySet()) {
            System.out.println("key: " + key);
            System.out.println("values: " + hourly.get(key));
        }*/
        return this.hourly.get(parameter.toString());
        //return hourly.get(parameter.toString());

    }
}
