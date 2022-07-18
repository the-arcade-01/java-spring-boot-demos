package com.arcade.restapi;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class StudentModel {
    private @Id @GeneratedValue Long id;
    private String name;
    private int age;

    public StudentModel() {
    }

    public StudentModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentModel id(Long id) {
        setId(id);
        return this;
    }

    public StudentModel name(String name) {
        setName(name);
        return this;
    }

    public StudentModel age(int age) {
        setAge(age);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StudentModel)) {
            return false;
        }
        StudentModel studentModel = (StudentModel) o;
        return Objects.equals(id, studentModel.id) && Objects.equals(name, studentModel.name)
                && age == studentModel.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                "}";
    }

}
