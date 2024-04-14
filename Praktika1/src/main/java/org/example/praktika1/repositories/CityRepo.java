package org.example.praktika1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.praktika1.modules.City;

public interface CityRepo extends JpaRepository<City, Long> {
}
