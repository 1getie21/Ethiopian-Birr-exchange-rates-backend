package com.getie.exchangeRate.country;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryDtoes implements Serializable {
    private long id;
    private String name;
    private  String flag;
}
 
