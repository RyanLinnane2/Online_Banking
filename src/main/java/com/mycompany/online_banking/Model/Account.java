/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.mycompany.online_banking.Model.User;

/**
 *
 * @author The Red Setters
 */

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Account {
    private int sortCode;
    private double balance;
    private int accountNum;
    private int accountID;
    private List<Transaction> transactions;
    
    public Account(){
        
    }

    public Account(int accountID, int sortCode, int balance, int accountNum, List<Transaction> transactions) {
        this.accountID = accountID;
        this.sortCode = sortCode;
        this.balance = balance;
        this.accountNum =  accountNum;
        this.transactions = transactions;
        
    }
    

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public void addNewTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
    
    
    
    

    
}
