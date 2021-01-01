package com.mapsa.marketplace.marketplace.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {
    private @Id long id;
    private String name;
    private String color;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "com_fk")
    private Collection<Category> company = new ArrayList<>();

}
