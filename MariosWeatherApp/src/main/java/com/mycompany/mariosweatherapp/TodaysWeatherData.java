
package com.mycompany.mariosweatherapp;

import java.util.List;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

/**
 *
 * @author mario
 */
public class TodaysWeatherData {
    private CustomCityLocation requestedLocation;
    private String currentDateTime;
    private Float currentTemperature;
    private Integer currentWeatherCode;

    public TodaysWeatherData() {
        this.requestedLocation = new CustomCityLocation();
        this.currentDateTime = "";
        this.currentTemperature = null;
        this.currentWeatherCode = null;
    }
    
    TodaysWeatherData(CustomCityLocation requestedLocation, io.swagger.forecast_weather_client.model.InlineResponse200 forecastWeatherApiResponse){
        
        this.requestedLocation = requestedLocation;
        this.currentDateTime = findCurrentTime();
        
        int index = findCurrentHourlyIndex(forecastWeatherApiResponse.getHourly().getTime());
        this.currentTemperature = findCurrentTemperature(forecastWeatherApiResponse.getHourly().getTemperature2m(), index);
        this.currentWeatherCode = findCurrentWeatherCode(forecastWeatherApiResponse.getHourly().getWeatherCode(), index);
        
    }
    
    public String getCurrentDAteTime() {
        return this.currentDateTime;
    }
    
    public Float getCurrentTemperature() {
        return this.currentTemperature;
    }
    
    public Integer getCurrentWeatherCode() {
        return this.currentWeatherCode;
    }
    
    public CustomCityLocation getLocationData() {
        return this.requestedLocation;
    }
    private static String findCurrentTime() {
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH':00'");
        
        String formattedDateTime = currentDateTime.format(formatter);
        
        return formattedDateTime;
    }
    
    private Float findCurrentTemperature(List<Float> hourlyTemperature, int index) {
        
        return hourlyTemperature.get(index);
    }
    
    private Integer findCurrentWeatherCode(List<Float> hourlyWeatherCode, int index) {
        
        return hourlyWeatherCode.get(index).intValue();
    }
     
    private Integer findCurrentHourlyIndex(List<String> hourlyTime) {
        
        for(int i = 0; i < hourlyTime.size(); i++) {
            
            if(hourlyTime.get(i).equalsIgnoreCase(this.currentDateTime)) {
                return i;
            }
        }
        
        return 0;
    }
}
