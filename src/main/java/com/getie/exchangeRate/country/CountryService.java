package com.getie.exchangeRate.country;

import com.getie.exchangeRate.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.getie.exchangeRate.utils.Util.getNullPropertyNames;


@Service
@AllArgsConstructor
public class CountryService {

    CountryRepository countryRepository;

    public Page<Country> findAll(Pageable pageable) {
       return   countryRepository.findAll(pageable);
    }
 
    public Country addRoles(Country country) {
        return  countryRepository.save(country);
    }
 
    public Country findRolesById(Long id) {
        try {
            return countryRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(
                            "Role with ID :" + id + " Not Found!")
            );
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }

    }
 
    public void deleteById(Long id) throws ResourceNotFoundException {
        countryRepository.deleteById(id);
    }
 
    public Country updateRoles(Country country, long roleId)     {
        var ro = findRolesById(roleId);

        BeanUtils.copyProperties(country, ro, getNullPropertyNames(country));
        return countryRepository.save(ro);
    }
}

