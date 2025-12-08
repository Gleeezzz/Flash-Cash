package com.umbert.flashcash1.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;
    private String iban;
    private double amount;

    public UserAccount plus(double amount) {
        this.amount += amount;
        return this;
    }
    public UserAccount minus(double amount) {
        this.amount -= amount;
        return this;
    }
}
