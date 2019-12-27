/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Services;

import com.mycompany.online_banking.Database.Databse;
import com.mycompany.online_banking.Model.Account;
import com.mycompany.online_banking.Model.Transaction;
import com.mycompany.online_banking.Model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ryan
 */
public class TransactionService {
    private Account getAccountById(int id) {
		for(Account account : accountList) {
	        if(account.getAccountID() == id) {
	            return account;
	        }
	    }
	    return null;
	}
	
    private List<Account> accountList = Databse.getAccountList();
    private String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    
    //lodge 
    public String lodgeMoney(int accId, double amount, String description) {
    	Account account = this.getAccountById(accId);
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        account.addNewTransaction(new Transaction(date, description, newBalance, 1, accId, 0, "LODGE"));
        String message = "Lodgement successful";
        return message;
    }
    
    //withdraw 
     public String withdrawMoney(int accId, double amount, String description) {    	
    	Account account = this.getAccountById(accId);
        double newBalance = account.getBalance() - amount;
        String message = "";
        if(newBalance < 0) {
        	message = "You have insufficient funds to complete transaction";
        } else {
        	account.setBalance(newBalance);
        	account.addNewTransaction(new Transaction(date, description, newBalance, 1, accId, 0, "WITHDRAW"));
        	message = "Withdrawal successful";
        }
        return message;
    }
    
    //transfer 
     public String transferMoney(int accId1, int accId2, double amount, String description) {
    	 Account account1 = this.getAccountById(accId1);
    	 Account account2 = this.getAccountById(accId2);
    	 double newBalance1 = account1.getBalance() - amount;
    	 String message = "";
    	 if(newBalance1 < 0) {
    		 message = "You have insufficient funds to complete transaction";
    	 } else {
    		 account1.setBalance(newBalance1);
    		 double newBalance2 = account2.getBalance() + amount;
    		 account2.setBalance(newBalance2);
    		 account1.addNewTransaction(new Transaction(date, description, newBalance1, 1, accId1, accId2, "TRANSFER OUT"));
    		 account2.addNewTransaction(new Transaction(date, description, newBalance2, 1, accId1, accId2, "TRANSFER IN"));
    		 message = "Money transferred successfully";
    	 }
    	 return message;
     }
}
