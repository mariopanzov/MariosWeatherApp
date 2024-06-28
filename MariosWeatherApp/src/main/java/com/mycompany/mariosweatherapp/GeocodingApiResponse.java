
package com.mycompany.mariosweatherapp;

import io.swagger.forecast_weather_client.ApiCallback;
import java.util.List;

public record GeocodingApiResponse(List<Result> results, double generationtime_ms) {
    public static GeocodingApiResponse createDefaultResponse() {
        List<Result> result = List.of(Result.createDefaultResult());
        return new GeocodingApiResponse(result, 0.00);
    }
}

