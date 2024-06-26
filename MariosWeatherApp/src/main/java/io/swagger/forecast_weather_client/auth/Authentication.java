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

package io.swagger.forecast_weather_client.auth;

import io.swagger.forecast_weather_client.Pair;

import java.util.Map;
import java.util.List;

public interface Authentication {
    /**
     * Apply authentication settings to header and query params.
     *
     * @param queryParams List of query parameters
     * @param headerParams Map of header parameters
     */
    void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
