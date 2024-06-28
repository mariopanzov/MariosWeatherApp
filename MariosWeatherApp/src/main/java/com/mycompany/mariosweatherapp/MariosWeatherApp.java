package com.mycompany.mariosweatherapp;

import com.google.gson.internal.LinkedTreeMap;
import org.threeten.bp.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.math.BigDecimal;

public class MariosWeatherApp {
    
    private HistoricalWeatherData historicalWeatherData;
    private TodaysWeatherData todaysWeatherData;
    GeocodingApiClient geocodingApiClient;
    
    private io.swagger.historical_weather_client.model.InlineResponse200 historicalWeatherApiResponse;
    private io.swagger.historical_weather_client.ApiClient historicalWeatherApiClient;
    private io.swagger.historical_weather_client.api.HistoricalWeatherApiApi historicalWeatherApi;
    
    private io.swagger.forecast_weather_client.model.InlineResponse200 forecastWeatherApiResponse;
    private io.swagger.forecast_weather_client.ApiClient forecastWeatherApiClient;
    private io.swagger.forecast_weather_client.api.WeatherForecastApisApi forecastWeatherApi;
    
    MariosWeatherApp(){
        
        historicalWeatherData = new HistoricalWeatherData();
        
        historicalWeatherApiClient = io.swagger.historical_weather_client.Configuration.getDefaultApiClient();
        historicalWeatherApiClient.setBasePath("https://archive-api.open-meteo.com");
        
        historicalWeatherApi = new io.swagger.historical_weather_client.api.HistoricalWeatherApiApi();
        
        
        forecastWeatherApiClient = io.swagger.forecast_weather_client.Configuration.getDefaultApiClient();
        forecastWeatherApiClient.setBasePath("https://api.open-meteo.com");
        
        forecastWeatherApi = new io.swagger.forecast_weather_client.api.WeatherForecastApisApi();
        
        geocodingApiClient = new GeocodingApiClient();
        
    }
    
    public HistoricalWeatherData pullHistoricalWeatherData(String searchForLocation, LocalDate date) {
        
        CustomCityLocation requestLocation = geocodingApiClient.callGeocodingApi(searchForLocation);
        
        if (!requestLocation.cityExists) {
            System.out.println("No request to Historical Weather API will be made...");
            return null;
        } else {
            LocalDate startDate = date; // LocalDate | The time interval to get weather data. A day must be specified as an ISO8601 date (e.g. 2022-01-01).
            LocalDate endDate =  date; // LocalDate | The time interval to get weather data. A day must be specified as an ISO8601 date (e.g. 2022-12-31).
            Float latitude = requestLocation.getCityLocation().getLatitude().floatValue(); // Float | WGS84 coordinate
            Float longitude = requestLocation.getCityLocation().getLongitude().floatValue(); // Float | WGS84 coordinate

            List<String> hourly = Arrays.asList("temperature_2m", "weather_code"); // List<String> | 
            List<String> daily = null;//Arrays.asList("temperature_2m_max", "temperature_2m_min", "weather_code"); // List<String> | 

            String temperatureUnit = "celsius"; // String | 
            String windSpeedUnit = "kmh"; // String | 
            String timeformat = "iso8601"; // String | If format `unixtime` is selected, all time values are returned in UNIX epoch time in seconds. Please not that all time is then in GMT+0! For daily values with unix timestamp, please apply `utc_offset_seconds` again to get the correct date.
            String timezone = "auto"; // String | If `timezone` is set, all timestamps are returned as local-time and data is returned starting at 0:00 local-time. Any time zone name from the [time zone database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) is supported.

            try {

                historicalWeatherApiResponse = historicalWeatherApi.v1ArchiveGet(startDate, endDate, latitude, longitude, hourly, daily, temperatureUnit, windSpeedUnit, timeformat, timezone);

                System.out.println("Response:\n" + historicalWeatherApiResponse);

                this.historicalWeatherData = new HistoricalWeatherData(requestLocation, historicalWeatherApiResponse);

            } catch (io.swagger.historical_weather_client.ApiException e) {
                System.err.println("Exception when calling HistoricalWeatherApiApi#v1ArchiveGet");
                System.err.println("Status code: " + e.getCode());
                System.err.println("Reason: " + e.getResponseBody());
                System.err.println("Response headers: " + e.getResponseHeaders());
                e.printStackTrace();      
            }

            return this.historicalWeatherData;
        }
    }
    
    public TodaysWeatherData pullForecastWeatherData(String searchForLocation) {

        
        CustomCityLocation requestLocation = geocodingApiClient.callGeocodingApi(searchForLocation);
        if(!requestLocation.cityExists){
            System.out.println("No request to Weather Forecast API will be made...");
            return null;
        } else {
            Float latitude = requestLocation.getCityLocation().getLatitude().floatValue(); // Float | WGS84 coordinate
            Float longitude = requestLocation.getCityLocation().getLongitude().floatValue(); // Float | WGS84 coordinate
            List<String> hourly = Arrays.asList("temperature_2m", "weather_code"); // List<String> | 
            List<String> daily = null;//Arrays.asList(""); // List<String> | 
            Boolean currentWeather = false; // Boolean | 
            String temperatureUnit = "celsius"; // String | 
            String windSpeedUnit = "kmh"; // String | 
            String timeformat = "iso8601"; // String | If format `unixtime` is selected, all time values are returned in UNIX epoch time in seconds. Please not that all time is then in GMT+0! For daily values with unix timestamp, please apply `utc_offset_seconds` again to get the correct date.
            String timezone = "auto"; // String | If `timezone` is set, all timestamps are returned as local-time and data is returned starting at 0:00 local-time. Any time zone name from the [time zone database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) is supported.
            Integer pastDays = null; // Integer | If `past_days` is set, yesterdays or the day before yesterdays data are also returned.

            try {

                forecastWeatherApiResponse = forecastWeatherApi.v1ForecastGet(latitude, longitude, hourly, daily, currentWeather, temperatureUnit, windSpeedUnit, timeformat, timezone, pastDays);

                System.out.println(forecastWeatherApiResponse);

                todaysWeatherData = new TodaysWeatherData(requestLocation, forecastWeatherApiResponse);
                
                System.out.println("---------------------------------------------");

                System.out.println(todaysWeatherData.getLocationData().getCity());
                System.out.println(todaysWeatherData.getCurrentDateTime());
                System.out.println(todaysWeatherData.getCurrentTemperature());
                System.out.println(todaysWeatherData.getCurrentWeatherCode());

            } catch (io.swagger.forecast_weather_client.ApiException e) {
                System.err.println("Exception when calling WeatherForecastApisApi#v1ForecastGet");
                System.err.println("Status code: " + e.getCode());
                System.err.println("Reason: " + e.getResponseBody());
                System.err.println("Response headers: " + e.getResponseHeaders());
                e.printStackTrace();
            }

            return todaysWeatherData;
        }
    }
}
