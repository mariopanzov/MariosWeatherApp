/*
 * Open-Meteo APIs
 * Open-Meteo offers free weather forecast APIs for open-source developers and non-commercial use. No API key is required.
 *
 * OpenAPI spec version: 1.0
 * Contact: info@open-meteo.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.forecast_weather_client.api;

import io.swagger.forecast_weather_client.ApiCallback;
import io.swagger.forecast_weather_client.ApiClient;
import io.swagger.forecast_weather_client.ApiException;
import io.swagger.forecast_weather_client.ApiResponse;
import io.swagger.forecast_weather_client.Configuration;
import io.swagger.forecast_weather_client.Pair;
import io.swagger.forecast_weather_client.ProgressRequestBody;
import io.swagger.forecast_weather_client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.forecast_weather_client.model.InlineResponse200;
import io.swagger.forecast_weather_client.model.InlineResponse400;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecastApisApi {
    private ApiClient apiClient;

    public WeatherForecastApisApi() {
        this(Configuration.getDefaultApiClient());
    }

    public WeatherForecastApisApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for v1ForecastGet
     * @param latitude WGS84 coordinate (required)
     * @param longitude WGS84 coordinate (required)
     * @param hourly  (optional)
     * @param daily  (optional)
     * @param currentWeather  (optional)
     * @param temperatureUnit  (optional, default to celsius)
     * @param windSpeedUnit  (optional, default to kmh)
     * @param timeformat If format &#x60;unixtime&#x60; is selected, all time values are returned in UNIX epoch time in seconds. Please not that all time is then in GMT+0! For daily values with unix timestamp, please apply &#x60;utc_offset_seconds&#x60; again to get the correct date. (optional, default to iso8601)
     * @param timezone If &#x60;timezone&#x60; is set, all timestamps are returned as local-time and data is returned starting at 0:00 local-time. Any time zone name from the [time zone database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) is supported. (optional)
     * @param pastDays If &#x60;past_days&#x60; is set, yesterdays or the day before yesterdays data are also returned. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call v1ForecastGetCall(Float latitude, Float longitude, List<String> hourly, List<String> daily, Boolean currentWeather, String temperatureUnit, String windSpeedUnit, String timeformat, String timezone, Integer pastDays, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v1/forecast";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (hourly != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "hourly", hourly));
        if (daily != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "daily", daily));
        if (latitude != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("latitude", latitude));
        if (longitude != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("longitude", longitude));
        if (currentWeather != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("current_weather", currentWeather));
        if (temperatureUnit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("temperature_unit", temperatureUnit));
        if (windSpeedUnit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("wind_speed_unit", windSpeedUnit));
        if (timeformat != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("timeformat", timeformat));
        if (timezone != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("timezone", timezone));
        if (pastDays != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("past_days", pastDays));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call v1ForecastGetValidateBeforeCall(Float latitude, Float longitude, List<String> hourly, List<String> daily, Boolean currentWeather, String temperatureUnit, String windSpeedUnit, String timeformat, String timezone, Integer pastDays, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'latitude' is set
        if (latitude == null) {
            throw new ApiException("Missing the required parameter 'latitude' when calling v1ForecastGet(Async)");
        }
        // verify the required parameter 'longitude' is set
        if (longitude == null) {
            throw new ApiException("Missing the required parameter 'longitude' when calling v1ForecastGet(Async)");
        }
        
        com.squareup.okhttp.Call call = v1ForecastGetCall(latitude, longitude, hourly, daily, currentWeather, temperatureUnit, windSpeedUnit, timeformat, timezone, pastDays, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * 7 day weather forecast for coordinates
     * 7 day weather variables in hourly and daily resolution for given WGS84 latitude and longitude coordinates. Available worldwide.
     * @param latitude WGS84 coordinate (required)
     * @param longitude WGS84 coordinate (required)
     * @param hourly  (optional)
     * @param daily  (optional)
     * @param currentWeather  (optional)
     * @param temperatureUnit  (optional, default to celsius)
     * @param windSpeedUnit  (optional, default to kmh)
     * @param timeformat If format &#x60;unixtime&#x60; is selected, all time values are returned in UNIX epoch time in seconds. Please not that all time is then in GMT+0! For daily values with unix timestamp, please apply &#x60;utc_offset_seconds&#x60; again to get the correct date. (optional, default to iso8601)
     * @param timezone If &#x60;timezone&#x60; is set, all timestamps are returned as local-time and data is returned starting at 0:00 local-time. Any time zone name from the [time zone database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) is supported. (optional)
     * @param pastDays If &#x60;past_days&#x60; is set, yesterdays or the day before yesterdays data are also returned. (optional)
     * @return InlineResponse200
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse200 v1ForecastGet(Float latitude, Float longitude, List<String> hourly, List<String> daily, Boolean currentWeather, String temperatureUnit, String windSpeedUnit, String timeformat, String timezone, Integer pastDays) throws ApiException {
        ApiResponse<InlineResponse200> resp = v1ForecastGetWithHttpInfo(latitude, longitude, hourly, daily, currentWeather, temperatureUnit, windSpeedUnit, timeformat, timezone, pastDays);
        return resp.getData();
    }

    /**
     * 7 day weather forecast for coordinates
     * 7 day weather variables in hourly and daily resolution for given WGS84 latitude and longitude coordinates. Available worldwide.
     * @param latitude WGS84 coordinate (required)
     * @param longitude WGS84 coordinate (required)
     * @param hourly  (optional)
     * @param daily  (optional)
     * @param currentWeather  (optional)
     * @param temperatureUnit  (optional, default to celsius)
     * @param windSpeedUnit  (optional, default to kmh)
     * @param timeformat If format &#x60;unixtime&#x60; is selected, all time values are returned in UNIX epoch time in seconds. Please not that all time is then in GMT+0! For daily values with unix timestamp, please apply &#x60;utc_offset_seconds&#x60; again to get the correct date. (optional, default to iso8601)
     * @param timezone If &#x60;timezone&#x60; is set, all timestamps are returned as local-time and data is returned starting at 0:00 local-time. Any time zone name from the [time zone database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) is supported. (optional)
     * @param pastDays If &#x60;past_days&#x60; is set, yesterdays or the day before yesterdays data are also returned. (optional)
     * @return ApiResponse&lt;InlineResponse200&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse200> v1ForecastGetWithHttpInfo(Float latitude, Float longitude, List<String> hourly, List<String> daily, Boolean currentWeather, String temperatureUnit, String windSpeedUnit, String timeformat, String timezone, Integer pastDays) throws ApiException {
        com.squareup.okhttp.Call call = v1ForecastGetValidateBeforeCall(latitude, longitude, hourly, daily, currentWeather, temperatureUnit, windSpeedUnit, timeformat, timezone, pastDays, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * 7 day weather forecast for coordinates (asynchronously)
     * 7 day weather variables in hourly and daily resolution for given WGS84 latitude and longitude coordinates. Available worldwide.
     * @param latitude WGS84 coordinate (required)
     * @param longitude WGS84 coordinate (required)
     * @param hourly  (optional)
     * @param daily  (optional)
     * @param currentWeather  (optional)
     * @param temperatureUnit  (optional, default to celsius)
     * @param windSpeedUnit  (optional, default to kmh)
     * @param timeformat If format &#x60;unixtime&#x60; is selected, all time values are returned in UNIX epoch time in seconds. Please not that all time is then in GMT+0! For daily values with unix timestamp, please apply &#x60;utc_offset_seconds&#x60; again to get the correct date. (optional, default to iso8601)
     * @param timezone If &#x60;timezone&#x60; is set, all timestamps are returned as local-time and data is returned starting at 0:00 local-time. Any time zone name from the [time zone database](https://en.wikipedia.org/wiki/List_of_tz_database_time_zones) is supported. (optional)
     * @param pastDays If &#x60;past_days&#x60; is set, yesterdays or the day before yesterdays data are also returned. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call v1ForecastGetAsync(Float latitude, Float longitude, List<String> hourly, List<String> daily, Boolean currentWeather, String temperatureUnit, String windSpeedUnit, String timeformat, String timezone, Integer pastDays, final ApiCallback<InlineResponse200> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = v1ForecastGetValidateBeforeCall(latitude, longitude, hourly, daily, currentWeather, temperatureUnit, windSpeedUnit, timeformat, timezone, pastDays, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse200>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}