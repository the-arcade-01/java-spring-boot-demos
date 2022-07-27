package com.arcade.customerapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CustomerModel {
    @Id
    @GeneratedValue
    private Long Id;
    private String name;
    private String email;
    private Integer number;

    public CustomerModel() {

    }

    public CustomerModel(String name, String email, Integer number) {
        this.name = name;
        this.email = email;
        this.number = number;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
