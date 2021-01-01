package com.mapsa.marketplace.marketplace.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String province;
    private String city;
    private String street1;
    private String street2;
    private String unit;
    private String floor;
    @OneToOne(mappedBy = "address")
    private Customer customer;

}
