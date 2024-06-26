
package com.mycompany.mariosweatherapp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CustomCityLocation {
   
    private String city;
    private LocationPair location;
    
    
    //Location data, temporary solution to choosing a location
    private static Map<String, LocationPair> locations = new HashMap<>();
    static {
        
        locations.put("Maribor", new LocationPair(new BigDecimal("46.55472"), new BigDecimal("15.64667")));
        locations.put("Ljubljana", new LocationPair(new BigDecimal("46.05108"), new BigDecimal("14.50513")));
        locations.put("Koper", new LocationPair(new BigDecimal("45.54694"), new BigDecimal("13.72944")));
        locations.put("Skopje", new LocationPair(new BigDecimal("41.99646"), new BigDecimal("21.43141")));
        
    }
    
        CustomCityLocation () {
        this.city = "";
        this.location = locations.getOrDefault(city, new LocationPair(new BigDecimal("46.55472"), new BigDecimal("15.64667")));
    }
        
    CustomCityLocation (String city) {
        this.city = city;
        this.location = locations.getOrDefault(city, new LocationPair(new BigDecimal("46.55472"), new BigDecimal("15.64667")));
    }
    
    public LocationPair getCityLocation() {
        return location;
    }
    
    public String getCity()
    {
        return city;
    }
}

