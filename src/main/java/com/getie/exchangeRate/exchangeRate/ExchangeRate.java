package com.getie.exchangeRate.exchangeRate;

import com.getie.exchangeRate.banks.Banks;
import com.getie.exchangeRate.country.Country;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"country_id", "banks_id"})})
public class ExchangeRate  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float buying;
    private float selling;
    @ManyToOne
    private Country country;
    @ManyToOne
    private Banks banks;
}
