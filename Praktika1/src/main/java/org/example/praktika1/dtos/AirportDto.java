package org.example.praktika1.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AirportDto {
    private Long id;
    private String name;
    private String iataCode;
    private String icaoCode;
    private Double latitude;
    private Double longitude;
    private CityDto city;

    public void setCountry(String name) {
    }

    public void setIso2CountryCode(String iso2CountryCode) {
    }

    public void setIso3CountryCode(String iso3CountryCode) {
    }
}
