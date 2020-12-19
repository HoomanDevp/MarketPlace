package com.mapsa.marketplace.marketplace.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    private @Id long id;
    private String name;
    private String color;
}
