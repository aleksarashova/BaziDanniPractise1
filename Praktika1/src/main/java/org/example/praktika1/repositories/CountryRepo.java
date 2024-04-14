package org.example.praktika1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.praktika1.modules.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
