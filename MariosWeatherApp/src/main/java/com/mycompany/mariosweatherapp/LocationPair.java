
package com.mycompany.mariosweatherapp;

import java.math.BigDecimal;

public class LocationPair {
    private BigDecimal latitude = null;
    private BigDecimal longitude = null;
    
    LocationPair(){}
    
    LocationPair(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public BigDecimal getLatitude() {
        return latitude;
    }
    
    public BigDecimal getLongitude() {
        return longitude;
    }
}
