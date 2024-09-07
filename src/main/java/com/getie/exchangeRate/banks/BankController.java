package com.getie.exchangeRate.banks;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banks")
@CrossOrigin(origins = {"http://localhost:3000"})

public class BankController {

    BankService bankService;

    @PostMapping
    public Banks addRoles(@RequestBody Banks banks) {
         return bankService.addRoles(banks);
    }

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public Page<Banks> findAll(Pageable pageable) {
        return    bankService.findAll(pageable);
    }
    @PutMapping("/{roleId}")
    public Banks updateRoles(@RequestBody Banks banks, @PathVariable long roleId) {
        return    bankService.updateRoles(banks,roleId);
    }

    @GetMapping("/{id}")
    public Banks findRolesById(@PathVariable Long id) {
      return bankService.findRolesById(id);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable Long id) {

        bankService.deleteById(id);
    }

}
