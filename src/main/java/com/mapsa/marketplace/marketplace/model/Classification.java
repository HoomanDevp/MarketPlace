package com.mapsa.marketplace.marketplace.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Classification {

    private @Id int  id;
    private @Basic long name;

    public Classification(int id, long name) {
        this.id = id;
        this.name = name;
    }


    /*@Column(name = "ID")
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "NAME")
    public long getName(){
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }

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
    }*/
}
