package com.codegym.case1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String image;
    private String phone;
    private String email;
    private String opening_time;
    private String closing_time;
    private Double revenue;
    private boolean status;

   
    @OneToOne
    private User user;

    private Boolean isLoyal;
}
