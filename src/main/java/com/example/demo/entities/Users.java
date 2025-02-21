package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private double age;
    private String email;
    private Boolean isActive;

    public Users(){

    }

    public Users(Long id,String name,String lastName,double age,String email,Boolean isActive){
        this.id=id;
        this.name=name;
        this.lastName=lastName;
        this.age=age;
        this.email=email;
        this.isActive=isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
