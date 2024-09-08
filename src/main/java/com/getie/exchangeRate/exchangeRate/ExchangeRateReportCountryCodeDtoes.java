package com.getie.exchangeRate.exchangeRate;

import com.getie.exchangeRate.banks.Banks;
import com.getie.exchangeRate.country.Country;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExchangeRateReportDtoes implements Serializable {
    private List<ExchangeRate> exchangeRates;
    private Banks banks;
}
 
