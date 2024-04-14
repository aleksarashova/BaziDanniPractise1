package org.example.praktika1.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
public class CountryDto {
    private String name;
    private String iso2CountryCode;
    private String iso3CountryCode;
}
