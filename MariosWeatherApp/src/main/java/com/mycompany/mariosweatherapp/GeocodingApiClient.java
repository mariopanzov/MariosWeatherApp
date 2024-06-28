
package com.mycompany.mariosweatherapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeocodingApiClient {
    private String BaseUrl = "https://geocoding-api.open-meteo.com/v1/search?name=Berlin&count=1&language=en&format=json";
    private final HttpClient client;
    private final ObjectMapper objectMapper; 

    public GeocodingApiClient() {
        
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }
    
    public CustomCityLocation callGeocodingApi(String searchForLocation) {
        
        String jsonResponse = "";
        CustomCityLocation cityLocation = new CustomCityLocation();
        
        //default generic values, just for declaration...
        GeocodingApiResponse geocodingApiResponse = GeocodingApiResponse.createDefaultResponse();
        
        //request data for the given city
        setBaseUrl(searchForLocation);
        
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.BaseUrl)).GET().build();
        
        //calling the Geocoding API
        try {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        jsonResponse = response.body();
        }
        catch(Exception e) {
            e.getStackTrace();
        }
        
        //getting data from jsonResponse
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            if(jsonNode.has("results")) {
                
                geocodingApiResponse = objectMapper.readValue(jsonResponse, GeocodingApiResponse.class);   
                cityLocation.setCity(geocodingApiResponse.results().getFirst().name());
                cityLocation.setLocation(geocodingApiResponse.results().getFirst().latitude(),
                                            geocodingApiResponse.results().getFirst().longitude());
                
                //using a boolean parameter in stead of setting the instance to null...
                cityLocation.setCityExists(true);
            }
            else {
                //if there is no "results" in the json, the reqiested city name was not found
                System.out.println("City not found, no results...");    
            }
        }
        catch(JsonProcessingException e) {
            e.printStackTrace();
        } 
        
        
        //System.out.println(geocodingApiResponse.results().getFirst().name());
        return cityLocation;
    }
    
    private void setBaseUrl(String searchForLocation) {
        this.BaseUrl = "https://geocoding-api.open-meteo.com/v1/search?name=" + searchForLocation + "&count=1&language=en&format=json";
        System.out.println(this.BaseUrl);
    }
}
