
package com.mycompany.mariosweatherapp;

import java.util.List;

public record Result(
        int id,
        String name,
        double latitude,
        double longitude,
        double elevation,
        String feature_code,
        String country_code,
        int admin1_id,
        int admin2_id,
        int admin3_id,
        int admin4_id,
        String timezone,
        int population,
        List<String> postcodes,
        int country_id,
        String country,
        String admin1,
        String admin2,
        String admin3,
        String admin4) {
    
    public static Result createDefaultResult() {
        return new Result(
                3195506, // id
                "Maribor", // name
                46.55472, // latitude
                15.64667, // longitude
                266.0, // elevation
                "PPLA", // feature_code
                "SI", // country_code
                3195505, // admin1_id
                0, // admin3_id
                0, // admin3_id
                0, // admin4_id
                "Europe/Ljubljana", // timezone
                95171, // population
                List.of(), // postcodes (empty list as it's not provided)
                3190538, // country_id
                "Slovenia", // country
                "Maribor", // admin1
                null, // admin3
                null, // admin3
                null // admin4
        );
    }
}
