package org.example.praktika1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.praktika1.modules.Airport;

import java.util.List;
import java.util.Set;

public interface AirportRepo extends JpaRepository<Airport, Long> {
    List<Airport> findAll();

    List<Airport> findByCountryIso2CodeIn(Set<String> strings);

    List<Airport> findByIcaoCodeInAndNameIn(Set<String> strings, Set<String> strings1);
}

