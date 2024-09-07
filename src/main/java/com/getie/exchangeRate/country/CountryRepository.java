package com.getie.exchangeRate.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Override
    Optional<Country> findById(Long aLong);
    Optional<Country> findByName(String name);
}