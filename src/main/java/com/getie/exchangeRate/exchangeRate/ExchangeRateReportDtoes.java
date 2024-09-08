package com.getie.exchangeRate.exchangeRate;

import com.getie.exchangeRate.banks.Banks;
import com.getie.exchangeRate.country.Country;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExchangeRateDtoes implements Serializable {
    private long id;
    private float buying;
    private float selling;
    private Country country;
    private Banks banks;
}
 
