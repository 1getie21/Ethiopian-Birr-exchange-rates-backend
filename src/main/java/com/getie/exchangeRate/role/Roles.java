package com.getie.exchangeRate.role;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private  String name;

}
