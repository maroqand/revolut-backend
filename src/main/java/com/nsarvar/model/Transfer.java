package com.nsarvar.model;

import java.util.Date;

/**
 * Created by nsarvar on 12/25/17.
 */
public class Transfer {
    private String fromAccountID;
    private String toAccountID;
    private double amount;
    private Date date;
    private String note;

    public Transfer(){
        this.date = new Date();
    }

    public Transfer(String fromAccountID, String toAccountID, double amount, String note) {
        this.fromAccountID = fromAccountID;
        this.toAccountID = toAccountID;
        this.amount = amount;
        this.date = new Date();
        this.note = note;
    }

    public String getFromAccountID() {
        return fromAccountID;
    }

    public void setFromAccountID(String fromAccountID) {
        this.fromAccountID = fromAccountID;
    }

    public String getToAccountID() {
        return toAccountID;
    }

    public void setToAccountID(String toAccountID) {
        this.toAccountID = toAccountID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
