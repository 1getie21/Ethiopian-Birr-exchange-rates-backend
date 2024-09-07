package com.getie.exchangeRate.role;

import com.getie.exchangeRate.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.getie.exchangeRate.utils.Util.getNullPropertyNames;


@Service
@AllArgsConstructor
public class RolesService {

    RolesRepository rolesRepository;

    public Page<Roles> findAll(Pageable pageable) {
       return   rolesRepository.findAll(pageable);
    }
 
    public Roles addRoles(Roles roles) {
        return  rolesRepository.save(roles);
    }
 
    public Roles findRolesById(Long id) {
        try {
            return rolesRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(
                            "Role with ID :" + id + " Not Found!")
            );
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }

    }
 
    public void deleteById(Long id) throws ResourceNotFoundException {
        rolesRepository.deleteById(id);
    }
 
    public Roles updateRoles( Roles roles,long roleId)     {
        var ro = findRolesById(roleId);

        BeanUtils.copyProperties(roles, ro, getNullPropertyNames(roles));
        return rolesRepository.save(ro);
    }
}

