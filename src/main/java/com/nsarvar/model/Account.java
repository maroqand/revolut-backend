package com.nsarvar.model;

import java.util.Date;

/**
 * Created by nsarvar on 12/25/17.
 */
public class Account {
    private String accountID;
    private String name;
    private double balance;
    private Date created;

    public Account() {
        this.created = new Date();
    }

    public Account(String accountID, String name, double balance) {
        this.accountID = accountID;
        this.name = name;
        this.balance = balance;
        this.created = new Date();
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
