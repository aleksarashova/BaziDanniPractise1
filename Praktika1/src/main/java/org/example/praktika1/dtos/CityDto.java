package org.example.praktika1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {
    private Long id;
    private String name;
    private CountryDto country;
    private String timezone;
}
