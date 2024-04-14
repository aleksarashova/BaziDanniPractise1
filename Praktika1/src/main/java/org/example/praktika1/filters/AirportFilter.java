package org.example.praktika1.filters;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public record AirportFilter(
        Set<String> countryIso2Codes,
        Set<Long> cityIds,
        Set<String> airportIcaoCodes,
        Set<String> airportNames
) {
    public AirportFilter() {
        this(new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public Collection<Object> getCountryIso2Codes() {
        return new HashSet<>(countryIso2Codes);
    }

    public Collection<Object> getCityIds() {
        return new HashSet<>(cityIds);
    }

    public Collection<Object> getAirportIcaoCodes() {
        return new HashSet<>(airportIcaoCodes);
    }

    public Collection<Object> getAirportNames() {
        return new HashSet<>(airportNames);
    }
}
