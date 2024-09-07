package com.getie.exchangeRate.exchangeRate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    @Override
    Optional<ExchangeRate> findById(Long aLong);

    Page<ExchangeRate> findAllByBanksId(Pageable pageable, long bankId);
}