package com.github.nkolytschew.springdata.jpa.entity;



import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String forename;
    private String surname;

    public Long age;


    // jpa needs this one... really hard!
    public User() {
    }

    // if we want to create an object via constructor
    public User(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    // get & set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
