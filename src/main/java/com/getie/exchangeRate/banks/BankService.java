package com.getie.exchangeRate.banks;

import com.getie.exchangeRate.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.getie.exchangeRate.utils.Util.getNullPropertyNames;


@Service
@AllArgsConstructor
public class BankService {

    BankRepository BAnkRepository;

    public Page<Banks> findAll(Pageable pageable) {
       return   BAnkRepository.findAll(pageable);
    }
 
    public Banks addRoles(Banks banks) {
        return  BAnkRepository.save(banks);
    }
 
    public Banks findRolesById(Long id) {
        try {
            return BAnkRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException(
                            "Role with ID :" + id + " Not Found!")
            );
        }
        catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }

    }
 
    public void deleteById(Long id) throws ResourceNotFoundException {
        BAnkRepository.deleteById(id);
    }
 
    public Banks updateRoles(Banks banks, long roleId)     {
        var ro = findRolesById(roleId);

        BeanUtils.copyProperties(banks, ro, getNullPropertyNames(banks));
        return BAnkRepository.save(ro);
    }
}

