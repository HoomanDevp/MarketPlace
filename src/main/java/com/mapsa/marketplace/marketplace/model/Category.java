package com.mapsa.marketplace.marketplace.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)

    private @Id long id;
    private String status;
    private String remarks;
    private long lockVersion;
}