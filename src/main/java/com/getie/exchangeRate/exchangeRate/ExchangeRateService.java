package com.getie.exchangeRate.exchangeRate;

import com.getie.exchangeRate.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.getie.exchangeRate.utils.Util.getNullPropertyNames;


@Service
@AllArgsConstructor
public class ExchangeRateService {

    ExchangeRateRepository exchangeRateRepository;

    public Page<ExchangeRate> findAll(Pageable pageable) {
        return exchangeRateRepository.findAll(pageable);
    }

    public ExchangeRate addRoles(ExchangeRate exchangeRate) {
        return exchangeRateRepository.save(exchangeRate);
    }

    public ExchangeRate findRolesById(Long id) {
        try {
            return exchangeRateRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(
                            "Role with ID :" + id + " Not Found!")
            );
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

    public void deleteById(Long id) throws ResourceNotFoundException {
        exchangeRateRepository.deleteById(id);
    }

    public ExchangeRate updateRoles(ExchangeRate exchangeRate, long roleId) {
        var ro = findRolesById(roleId);

        BeanUtils.copyProperties(exchangeRate, ro, getNullPropertyNames(exchangeRate));
        return exchangeRateRepository.save(ro);
    }

    public Page<ExchangeRate> findAllByBanks(Pageable pageable, long bankId) {

        return exchangeRateRepository.findAllByBanksId(pageable,bankId);
    }
}

