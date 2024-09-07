package com.getie.exchangeRate.exchangeRate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exchange-rate")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ExchangeRateController {

    ExchangeRateService exchangeRateService;

    @PostMapping
    public ExchangeRate addRoles(@RequestBody ExchangeRate exchangeRate) {
        return exchangeRateService.addRoles(exchangeRate);
    }

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping
    public Page<ExchangeRate> findAll(Pageable pageable) {
        return exchangeRateService.findAll(pageable);
    }
    @GetMapping("/bank/{bankId}")
    public Page<ExchangeRate> findAllByBanks(Pageable pageable,@PathVariable long bankId) {
        return exchangeRateService.findAllByBanks(pageable,bankId);
    }


    @PutMapping("/{roleId}")
    public ExchangeRate updateRoles(@RequestBody ExchangeRate exchangeRate, @PathVariable long roleId) {
        return exchangeRateService.updateRoles(exchangeRate, roleId);
    }

    @GetMapping("/{id}")
    public ExchangeRate findRolesById(@PathVariable Long id) {
        return exchangeRateService.findRolesById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable Long id) {
        exchangeRateService.deleteById(id);
    }

}
