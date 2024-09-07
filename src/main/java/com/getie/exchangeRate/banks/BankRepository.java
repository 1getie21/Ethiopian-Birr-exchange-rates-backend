package com.getie.exchangeRate.banks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Banks, Long> {
    @Override
    Optional<Banks> findById(Long aLong);
    Optional<Banks> findByName(String name);
}