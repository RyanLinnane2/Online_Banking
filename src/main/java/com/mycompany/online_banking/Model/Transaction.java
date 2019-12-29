/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Model;

/**
 *
 * @author x18145761, x18137695
 */
public class Transaction {

    private String date;
    private String description;
    private double newBalance;
    private String debit_credit;
    private String transID;
    private int accId1;
    private int accId2;
    private String transactionType;

    public Transaction() {

    }

    public Transaction(String date, String description, double newBalance, String debit_credit) {
        this.date = date;
        this.description = description;
        this.newBalance = newBalance;
        this.debit_credit = debit_credit;
    }

    public Transaction(String date, String description, double newBalance, String transID, int accId1, int accId2, String transactionType) {
        this.date = date;
        this.description = description;
        this.newBalance = newBalance;
        this.transID = transID;
        this.accId1 = accId1;
        this.accId2 = accId2;
        this.transactionType = transactionType;
    }
    
    public Transaction(String date, double newBalance, String transID, int accId1, int accId2, String transactionType) {
        this.date = date;
        this.newBalance = newBalance;
        this.transID = transID;
        this.accId1 = accId1;
        this.accId2 = accId2;
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public String getTransID() {
        return transID;
    }

    public int getAccId1() {
        return accId1;
    }

    public String getDate() {
        return date;
    }

    public int getAccId2() {
        return accId2;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public void setAccId1(int accId1) {
        this.accId1 = accId1;
    }

    public void setAccId2(int accId2) {
        this.accId2 = accId2;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
