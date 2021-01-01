package com.mapsa.marketplace.marketplace.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int customerNumber;
    private String firstName;
    private String lastName;
    private int phone;
    private String email;
    @OneToOne
    @JoinColumn(name = "address_fk" , nullable = false)
    private Address address;


}
