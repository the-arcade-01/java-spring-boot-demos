package com.arcade.cat.Entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CatModel {
    @Id
    @GeneratedValue
    Long Id;
    String name;
    Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CatModel catModel = (CatModel) o;
        return Id != null && Objects.equals(Id, catModel.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
