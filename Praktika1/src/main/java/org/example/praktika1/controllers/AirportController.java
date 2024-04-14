package org.example.praktika1.controllers;

import org.example.praktika1.dtos.AirportDto;
import org.example.praktika1.filters.AirportFilter;
import org.example.praktika1.modules.Airport;
import org.example.praktika1.modules.City;
import org.example.praktika1.modules.Country;
import org.example.praktika1.repositories.AirportRepo;
import org.example.praktika1.services.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class AirportController {

    @Autowired
    private AirportRepo airportRepository;

    @Autowired
    private AirportService airportService;

    @GetMapping("/airports")
    @ResponseBody
    public List<AirportDto> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        List<AirportDto> airportDtos = new ArrayList<>();

        for (Airport airport : airports) {
            AirportDto airportDto = new AirportDto();
            airportDto.setId(airport.getId());
            airportDto.setName(airport.getName());
            airportDto.setIataCode(airport.getIataCode());
            airportDto.setIcaoCode(airport.getIcaoCode());
            airportDto.setLatitude(airport.getLatitude());
            airportDto.setLongitude(airport.getLongitude());

            City city = airport.getCity();
            if (city != null) {
                airportDto.setCity(city.getName());

                Country country = city.getCountry();
                if (country != null) {
                    airportDto.setCountry(country.getName());
                    airportDto.setIso2CountryCode(country.getIso2CountryCode());
                    airportDto.setIso3CountryCode(country.getIso3CountryCode());
                }
            }

            airportDtos.add(airportDto);
        }

        return airportDtos;
    }

    @PostMapping("/airports/filter")
    public ResponseEntity<?> filterAirports(@RequestParam boolean countryAsRoot, @RequestBody AirportFilter airportFilter) {
        List<?> result;

        if (countryAsRoot) {
            result = airportService.filterAndGroupByCountry(airportFilter);
        } else {
            result = airportService.filterAndGroupByAirport(airportFilter);
        }

        return ResponseEntity.ok(result);
    }

}
