package com.mapsa.marketplace.marketplace.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Classification {

    private @Id int  id;
    private @Basic long name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_fk")
    private Collection<Category> category = new ArrayList<>();

    /*public Classification(int id, long name) {
        this.id = id;
        this.name = name;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classification that = (Classification) o;

        if (id != that.id) return false;
        if (name != that.name) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (name^ (name >>> 32));

        return result;
    }
}
