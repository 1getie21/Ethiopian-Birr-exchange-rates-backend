package com.getie.exchangeRate.country;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CountryController {

    CountryService countryService;

    @PostMapping
    public Country addRoles(@RequestBody Country country) {
        return countryService.addRoles(country);
    }

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Page<Country> findAll(Pageable pageable) {
        return countryService.findAll(pageable);
    }

    @PutMapping("/{roleId}")
    public Country updateRoles(@RequestBody Country country, @PathVariable long roleId) {
        return countryService.updateRoles(country, roleId);
    }

    @GetMapping("/{id}")
    public Country findRolesById(@PathVariable Long id) {
        return countryService.findRolesById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable Long id) {

        countryService.deleteById(id);
    }

}
