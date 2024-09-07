package com.getie.exchangeRate.role;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = {"http://localhost:3000"})
public class RolesController   {

    RolesService rolesService;

    @PostMapping
    public Roles addRoles(@RequestBody Roles roles) {
         return rolesService.addRoles(roles);
    }

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping
    public Page<Roles> findAll(Pageable pageable) {
        return    rolesService.findAll(pageable);
    }
    @PutMapping("/{roleId}")
    public Roles updateRoles(@RequestBody Roles roles,@PathVariable long roleId) {
        return    rolesService.updateRoles(roles,roleId);
    }

    @GetMapping("/{id}")
    public Roles findRolesById(@PathVariable Long id) {
      return rolesService.findRolesById(id);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable Long id) {

        rolesService.deleteById(id);
    }

}
