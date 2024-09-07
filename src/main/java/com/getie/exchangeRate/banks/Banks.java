package com.getie.exchangeRate.banks;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Banks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private  String name;

}
