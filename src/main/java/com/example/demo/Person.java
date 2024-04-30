package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persons")

public class Person {
    @Id
    private int userID;
    private String Name;
    private String Password;
    private String EMail;

    Person(@JsonProperty("Name") String Name, @JsonProperty("id") int id, @JsonProperty("Email") String EMail, @JsonProperty("Password") String Password) {
        this.userID = id;
        this.EMail = EMail;
        this.Password = Password;
        this.Name = Name;
    }

    public Person() {

    }

    public int getId() {
        return userID;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEMail() {
        return EMail;
    }

    public void setId(int id) {
        this.userID = id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

}
