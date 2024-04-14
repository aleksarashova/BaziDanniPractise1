package org.example.praktika1.services;

import org.example.praktika1.filters.AirportFilter;
import org.example.praktika1.modules.Airport;
import org.example.praktika1.modules.City;
import org.example.praktika1.modules.Country;
import org.example.praktika1.repositories.AirportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AirportService {

    @Autowired
    private AirportRepo airportRepo;

    public List<?> filterAndGroupByCountry(AirportFilter airportFilter, Pageable pageable) {
        List<Airport> airports = airportRepo.findAll();
        Page<Airport> airportPage = airportRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        List<?> result;

        if (airportFilter != null) {
            result = airports.stream()
                    .filter(airport -> {
                        if (!airportFilter.getCountryIso2Codes().isEmpty() &&
                                !airportFilter.getCountryIso2Codes().contains(airport.getCity().getCountry().getIso2CountryCode())) {
                            return false;
                        }
                        if (!airportFilter.getCityIds().isEmpty() &&
                                !airportFilter.getCityIds().contains(airport.getCity().getId())) {
                            return false;
                        }
                        if (!airportFilter.getAirportIcaoCodes().isEmpty() &&
                                !airportFilter.getAirportIcaoCodes().contains(airport.getIcaoCode())) {
                            return false;
                        }
                        if (!airportFilter.getAirportNames().isEmpty() &&
                                !airportFilter.getAirportNames().contains(airport.getName())) {
                            return false;
                        }
                        return true;
                    })
                    .collect(Collectors.toList());
        } else {
            result = airports;
        }

        Map<Country, Map<City, List<Airport>>> groupedByCountryAndCity = airports.stream()
                .collect(Collectors.groupingBy(
                        airport -> airport.getCity().getCountry(),
                        Collectors.groupingBy(
                                Airport::getCity,
                                Collectors.toList()
                        )
                ));

        result = (List<?>) groupedByCountryAndCity;
        return result;
    }

    public List<?> filterAndGroupByAirport(AirportFilter airportFilter, Pageable pageable) {
        List<Airport> airports = airportRepo.findAll();
        Page<Airport> airportPage = airportRepo.findAll((org.springframework.data.domain.Pageable) pageable);
        List<?> result;

        if (airportFilter != null) {
            result = airports.stream()
                    .filter(airport -> {
                        if (!airportFilter.getCountryIso2Codes().isEmpty() &&
                                !airportFilter.getCountryIso2Codes().contains(airport.getCity().getCountry().getIso2CountryCode())) {
                            return false;
                        }
                        if (!airportFilter.getCityIds().isEmpty() &&
                                !airportFilter.getCityIds().contains(airport.getCity().getId())) {
                            return false;
                        }
                        if (!airportFilter.getAirportIcaoCodes().isEmpty() &&
                                !airportFilter.getAirportIcaoCodes().contains(airport.getIcaoCode())) {
                            return false;
                        }
                        if (!airportFilter.getAirportNames().isEmpty() &&
                                !airportFilter.getAirportNames().contains(airport.getName())) {
                            return false;
                        }
                        return true;
                    })
                    .collect(Collectors.toList());
        } else {
            result = airports;
        }

        Map<Airport, Map<City, Country>> groupedByAirportAndCity = airports.stream()
                .collect(Collectors.groupingBy(
                        airport -> airport,
                        Collectors.toMap(
                                Airport::getCity,
                                airport -> airport.getCity().getCountry()
                        )
                ));

        result = (List<?>) groupedByAirportAndCity;
        return result;
    }
}
