package com.bm.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private Long id;
    private String owner;
    private double balance;

    // Constructors, Getters, and Setters
    public Account() {}

    public Account(Long id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public Long getId() { return id; }
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}