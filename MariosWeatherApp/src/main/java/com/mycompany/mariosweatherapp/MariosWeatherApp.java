package com.mycompany.mariosweatherapp;

import io.swagger.client.*;
import io.swagger.client.model.*;
import io.swagger.client.ApiException;
import io.swagger.client.api.HistoricalWeatherApiApi;

import org.threeten.bp.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MariosWeatherApp {
  public static void main(String[] args) {
      
      ApiClient defaultClient = Configuration.getDefaultApiClient();
      defaultClient.setBasePath("https://archive-api.open-meteo.com");
      
      HistoricalWeatherApiApi apiInstance = new HistoricalWeatherApiApi();
      
      LocalDate startDate = LocalDate.of(2024,6,18); // LocalDate | The time interval to get weather data. A day must be specified as an ISO8601 date (e.g. 2022-01-01).
      LocalDate endDate =  LocalDate.of(2024,6,18); // LocalDate | The time interval to get weather data. A day must be specified as an ISO8601 date (e.g. 2022-12-31).
      Float latitude = 46.5547f; // Float | WGS84 coordinate
      Float longitude = 15.6467f; // Float | WGS84 coordinate
      List<String> hourly = Arrays.asList("temperature_2m"); // List<String> | 
      List<String> daily = Arrays.asList("weather_code"); // List<String> | 
      String temperatureUnit = "celsius"; // String | 
      String windSpeedUnit = "kmh"; // String | 
      String timeformat = "iso8601"; // String | If format `unixtime` is selected, all time values are returned in UNIX epoch time in seconds. Please not that all time is then in GMT+0! For daily values with unix timestamp, please apply `utc_offset_seconds` again to get the correct date.
      String timezone = "GMT"; // String | If `timezone` is set, all timestamps are returned as local-time and data is returned starting at 0:00 local-time. Any time zone name from the [time zone database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) is supported.
      try {
          System.out.println("aaaaaaaaa");
          InlineResponse200 result = apiInstance.v1ArchiveGet(startDate, endDate, latitude, longitude, hourly, daily, temperatureUnit, windSpeedUnit, timeformat, timezone);
          System.out.println(result);
      } catch (ApiException e) {
          System.err.println("Exception when calling HistoricalWeatherApiApi#v1ArchiveGet");
          System.err.println("Status code: " + e.getCode());
          System.err.println("Reason: " + e.getResponseBody());
          System.err.println("Response headers: " + e.getResponseHeaders());
          e.printStackTrace();      }
  }
}
