/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Services;

import com.fasterxml.uuid.Generators;
import com.mycompany.online_banking.Database.Databse;
import com.mycompany.online_banking.Model.Account;
import com.mycompany.online_banking.Model.Transaction;
import com.mycompany.online_banking.Model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author x18145761, x18137695
 */
public class TransactionService {

    private Account getAccountById(int id) {
        for (Account account : accountList) {
            if (account.getAccountID() == id) {
                return account;
            }
        }
        return null;
    }

    private Account getAccountBySortCodeAndAccNum(int sortCode, int accountNum) {
        for (Account account : accountList) {
            if ((account.getSortCode() == sortCode) && (account.getAccountNum() == accountNum)) {
                return account;
            }
        }
        return null;
    }

    private List<Account> accountList = Databse.getAccountList();
//    private String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    //lodge - with account ID
    public String lodgeMoney(int accId, double amount, String description) {
        Account account = this.getAccountById(accId);
        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        UUID uuid = Generators.randomBasedGenerator().generate();
        account.addNewTransaction(new Transaction(date, description, newBalance, uuid.toString(), accId, 0, "LODGE"));
        String message = "Lodgement successful";
        return message;
    }

    //lodge - with sort code and acc number
    public String lodgeMoney2(int sortCode, int accountNum, double amount, String description) {
        Account account = this.getAccountBySortCodeAndAccNum(sortCode, accountNum);
        double newBalance = account.getBalance() + amount;
        int accId = account.getAccountID();
        account.setBalance(newBalance);
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        UUID uuid = Generators.randomBasedGenerator().generate();
        account.addNewTransaction(new Transaction(date, description, newBalance, uuid.toString(), accId, 0, "LODGE"));
        String message = "Lodgement successful";
        return message;
    }

    //withdraw - with account ID
    public String withdrawMoney(int accId, double amount, String description) {
        Account account = this.getAccountById(accId);
        double newBalance = account.getBalance() - amount;
        String message = "";
        if (newBalance < 0) {
            message = "You have insufficient funds to complete transaction";
        } else {
            account.setBalance(newBalance);
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            UUID uuid = Generators.randomBasedGenerator().generate();
            account.addNewTransaction(new Transaction(date, description, newBalance, uuid.toString(), accId, 0, "WITHDRAW"));
            message = "Withdrawal successful";
        }
        return message;
    }

    //withdraw - with sort code and acc number
    public String withdrawMoney2(int sortCode, int accountNum, double amount, String description) {
        Account account = this.getAccountBySortCodeAndAccNum(sortCode, accountNum);
        double newBalance = account.getBalance() - amount;
        int accId = account.getAccountID();
        String message = "";
        if (newBalance < 0) {
            message = "You have insufficient funds to complete transaction";
        } else {
            account.setBalance(newBalance);
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            UUID uuid = Generators.randomBasedGenerator().generate();
            account.addNewTransaction(new Transaction(date, description, newBalance, uuid.toString(), accId, 0, "WITHDRAW"));
            message = "Withdrawal successful";
        }
        return message;
    }

    //transfer - with account ID
    public String transferMoney(int accId1, int accId2, double amount, String description) {
        Account account1 = this.getAccountById(accId1);
        Account account2 = this.getAccountById(accId2);
        double newBalance1 = account1.getBalance() - amount;
        String message = "";
        if (newBalance1 < 0) {
            message = "You have insufficient funds to complete transaction";
        } else {
            account1.setBalance(newBalance1);
            double newBalance2 = account2.getBalance() + amount;
            account2.setBalance(newBalance2);
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            UUID uuid = Generators.randomBasedGenerator().generate();
            account1.addNewTransaction(new Transaction(date, description, newBalance1, uuid.toString(), accId1, accId2, "TRANSFER OUT"));
//    		 uuid = Generators.randomBasedGenerator().generate();
            account2.addNewTransaction(new Transaction(date, description, newBalance2, uuid.toString(), accId1, accId2, "TRANSFER IN"));
            message = "Money transferred successfully";
        }
        return message;
    }

    //transfer - with sort code and acc number
    public String transferMoney2(int sortCode1, int accountNum1, int sortCode2, int accountNum2, double amount, String description) {
        Account account1 = this.getAccountBySortCodeAndAccNum(sortCode1, accountNum1);
        Account account2 = this.getAccountBySortCodeAndAccNum(sortCode2, accountNum2);
        int accId1 = account1.getAccountID();
        int accId2 = account2.getAccountID();
        double newBalance1 = account1.getBalance() - amount;
        String message = "";
        if (newBalance1 < 0) {
            message = "You have insufficient funds to complete transaction";
        } else {
            account1.setBalance(newBalance1);
            double newBalance2 = account2.getBalance() + amount;
            account2.setBalance(newBalance2);
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            UUID uuid = Generators.randomBasedGenerator().generate();
            account1.addNewTransaction(new Transaction(date, description, newBalance1, uuid.toString(), accId1, accId2, "TRANSFER OUT"));
//    		 uuid = Generators.randomBasedGenerator().generate();
            account2.addNewTransaction(new Transaction(date, description, newBalance2, uuid.toString(), accId1, accId2, "TRANSFER IN"));
            message = "Money transferred successfully";
        }
        return message;
    }
}
