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

package io.swagger.forecast_weather_client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.forecast_weather_client.model.CurrentWeather;
import io.swagger.forecast_weather_client.model.DailyResponse;
import io.swagger.forecast_weather_client.model.HourlyResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * InlineResponse200
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2024-06-25T15:17:37.234703587Z[GMT]")

public class InlineResponse200 {
  @SerializedName("latitude")
  private BigDecimal latitude = null;

  @SerializedName("longitude")
  private BigDecimal longitude = null;

  @SerializedName("elevation")
  private BigDecimal elevation = null;

  @SerializedName("generationtime_ms")
  private BigDecimal generationtimeMs = null;

  @SerializedName("utc_offset_seconds")
  private Integer utcOffsetSeconds = null;

  @SerializedName("hourly")
  private HourlyResponse hourly = null;

  @SerializedName("hourly_units")
  private Map<String, String> hourlyUnits = null;

  @SerializedName("daily")
  private DailyResponse daily = null;

  @SerializedName("daily_units")
  private Map<String, String> dailyUnits = null;

  @SerializedName("current_weather")
  private CurrentWeather currentWeather = null;

  public InlineResponse200 latitude(BigDecimal latitude) {
    this.latitude = latitude;
    return this;
  }

   /**
   * WGS84 of the center of the weather grid-cell which was used to generate this forecast. This coordinate might be up to 5 km away.
   * @return latitude
  **/
  @Schema(example = "52.52", description = "WGS84 of the center of the weather grid-cell which was used to generate this forecast. This coordinate might be up to 5 km away.")
  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public InlineResponse200 longitude(BigDecimal longitude) {
    this.longitude = longitude;
    return this;
  }

   /**
   * WGS84 of the center of the weather grid-cell which was used to generate this forecast. This coordinate might be up to 5 km away.
   * @return longitude
  **/
  @Schema(description = "WGS84 of the center of the weather grid-cell which was used to generate this forecast. This coordinate might be up to 5 km away.")
  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public InlineResponse200 elevation(BigDecimal elevation) {
    this.elevation = elevation;
    return this;
  }

   /**
   * The elevation in meters of the selected weather grid-cell. In mountain terrain it might differ from the location you would expect.
   * @return elevation
  **/
  @Schema(example = "44.812", description = "The elevation in meters of the selected weather grid-cell. In mountain terrain it might differ from the location you would expect.")
  public BigDecimal getElevation() {
    return elevation;
  }

  public void setElevation(BigDecimal elevation) {
    this.elevation = elevation;
  }

  public InlineResponse200 generationtimeMs(BigDecimal generationtimeMs) {
    this.generationtimeMs = generationtimeMs;
    return this;
  }

   /**
   * Generation time of the weather forecast in milli seconds. This is mainly used for performance monitoring and improvements.
   * @return generationtimeMs
  **/
  @Schema(example = "2.2119", description = "Generation time of the weather forecast in milli seconds. This is mainly used for performance monitoring and improvements.")
  public BigDecimal getGenerationtimeMs() {
    return generationtimeMs;
  }

  public void setGenerationtimeMs(BigDecimal generationtimeMs) {
    this.generationtimeMs = generationtimeMs;
  }

  public InlineResponse200 utcOffsetSeconds(Integer utcOffsetSeconds) {
    this.utcOffsetSeconds = utcOffsetSeconds;
    return this;
  }

   /**
   * Applied timezone offset from the &amp;timezone&#x3D; parameter.
   * @return utcOffsetSeconds
  **/
  @Schema(example = "3600", description = "Applied timezone offset from the &timezone= parameter.")
  public Integer getUtcOffsetSeconds() {
    return utcOffsetSeconds;
  }

  public void setUtcOffsetSeconds(Integer utcOffsetSeconds) {
    this.utcOffsetSeconds = utcOffsetSeconds;
  }

  public InlineResponse200 hourly(HourlyResponse hourly) {
    this.hourly = hourly;
    return this;
  }

   /**
   * For each selected weather variable, data will be returned as a floating point array. Additionally a &#x60;time&#x60; array will be returned with ISO8601 timestamps.
   * @return hourly
  **/
  @Schema(description = "For each selected weather variable, data will be returned as a floating point array. Additionally a `time` array will be returned with ISO8601 timestamps.")
  public HourlyResponse getHourly() {
    return hourly;
  }

  public void setHourly(HourlyResponse hourly) {
    this.hourly = hourly;
  }

  public InlineResponse200 hourlyUnits(Map<String, String> hourlyUnits) {
    this.hourlyUnits = hourlyUnits;
    return this;
  }

  public InlineResponse200 putHourlyUnitsItem(String key, String hourlyUnitsItem) {
    if (this.hourlyUnits == null) {
      this.hourlyUnits = new HashMap<String, String>();
    }
    this.hourlyUnits.put(key, hourlyUnitsItem);
    return this;
  }

   /**
   * For each selected weather variable, the unit will be listed here.
   * @return hourlyUnits
  **/
  @Schema(description = "For each selected weather variable, the unit will be listed here.")
  public Map<String, String> getHourlyUnits() {
    return hourlyUnits;
  }

  public void setHourlyUnits(Map<String, String> hourlyUnits) {
    this.hourlyUnits = hourlyUnits;
  }

  public InlineResponse200 daily(DailyResponse daily) {
    this.daily = daily;
    return this;
  }

   /**
   * For each selected daily weather variable, data will be returned as a floating point array. Additionally a &#x60;time&#x60; array will be returned with ISO8601 timestamps.
   * @return daily
  **/
  @Schema(description = "For each selected daily weather variable, data will be returned as a floating point array. Additionally a `time` array will be returned with ISO8601 timestamps.")
  public DailyResponse getDaily() {
    return daily;
  }

  public void setDaily(DailyResponse daily) {
    this.daily = daily;
  }

  public InlineResponse200 dailyUnits(Map<String, String> dailyUnits) {
    this.dailyUnits = dailyUnits;
    return this;
  }

  public InlineResponse200 putDailyUnitsItem(String key, String dailyUnitsItem) {
    if (this.dailyUnits == null) {
      this.dailyUnits = new HashMap<String, String>();
    }
    this.dailyUnits.put(key, dailyUnitsItem);
    return this;
  }

   /**
   * For each selected daily weather variable, the unit will be listed here.
   * @return dailyUnits
  **/
  @Schema(description = "For each selected daily weather variable, the unit will be listed here.")
  public Map<String, String> getDailyUnits() {
    return dailyUnits;
  }

  public void setDailyUnits(Map<String, String> dailyUnits) {
    this.dailyUnits = dailyUnits;
  }

  public InlineResponse200 currentWeather(CurrentWeather currentWeather) {
    this.currentWeather = currentWeather;
    return this;
  }

   /**
   * Current weather conditions with the attributes: time, temperature, wind_speed, wind_direction and weather_code
   * @return currentWeather
  **/
  @Schema(description = "Current weather conditions with the attributes: time, temperature, wind_speed, wind_direction and weather_code")
  public CurrentWeather getCurrentWeather() {
    return currentWeather;
  }

  public void setCurrentWeather(CurrentWeather currentWeather) {
    this.currentWeather = currentWeather;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.latitude, inlineResponse200.latitude) &&
        Objects.equals(this.longitude, inlineResponse200.longitude) &&
        Objects.equals(this.elevation, inlineResponse200.elevation) &&
        Objects.equals(this.generationtimeMs, inlineResponse200.generationtimeMs) &&
        Objects.equals(this.utcOffsetSeconds, inlineResponse200.utcOffsetSeconds) &&
        Objects.equals(this.hourly, inlineResponse200.hourly) &&
        Objects.equals(this.hourlyUnits, inlineResponse200.hourlyUnits) &&
        Objects.equals(this.daily, inlineResponse200.daily) &&
        Objects.equals(this.dailyUnits, inlineResponse200.dailyUnits) &&
        Objects.equals(this.currentWeather, inlineResponse200.currentWeather);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude, elevation, generationtimeMs, utcOffsetSeconds, hourly, hourlyUnits, daily, dailyUnits, currentWeather);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    elevation: ").append(toIndentedString(elevation)).append("\n");
    sb.append("    generationtimeMs: ").append(toIndentedString(generationtimeMs)).append("\n");
    sb.append("    utcOffsetSeconds: ").append(toIndentedString(utcOffsetSeconds)).append("\n");
    sb.append("    hourly: ").append(toIndentedString(hourly)).append("\n");
    sb.append("    hourlyUnits: ").append(toIndentedString(hourlyUnits)).append("\n");
    sb.append("    daily: ").append(toIndentedString(daily)).append("\n");
    sb.append("    dailyUnits: ").append(toIndentedString(dailyUnits)).append("\n");
    sb.append("    currentWeather: ").append(toIndentedString(currentWeather)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}