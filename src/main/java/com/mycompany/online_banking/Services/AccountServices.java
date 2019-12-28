/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Services;

import com.mycompany.online_banking.Model.User;
import com.mycompany.online_banking.Database.Databse;
import com.mycompany.online_banking.Model.Transaction;
import com.mycompany.online_banking.Model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author x18145761, x18137695
 *
 *
 */
public class AccountServices {

    Databse db = new Databse();
    private List<Account> accountList = Databse.getAccountList();
    private List<User> userList = Databse.getUserList();
    Random rand = new Random();

    private User getUserById(int id) {
        userList = Databse.getUserList();
        for (User user : userList) {
            if (user.getUserID() == id) {
                return user;
            }
        }
        return null;
    }

    // create a new account for a particular user add new accountID & accountNum
    public Account createAccount(Account account, int userId) {
        int size = accountList.size() + 1;
        // set the new account ID number to be the length of the arraylist
        account.setAccountID(size);

        // Obtain a number between to be used as new account number
        int n = rand.nextInt(1000000);
        int sortCode = rand.nextInt(999999);
        // Check if randomly generated number already exists as an account numnber
        // If it does exist create another random number until unique number created
        if (account.getAccountNum() == n) {
            n = rand.nextInt(1000000);
        } else {
            // set unique random number as account number
            account.setAccountNum(n);
            account.setSortCode(sortCode);
        }
        // add new account to the database accountList

        // add the account to the database userList.
        accountList.add(account);
        this.getUserById(userId).getAccounts().add(account);
        return account;
    }

    // get the balance of a particular user account
    public double getBalance(int accountID) {
        // get current balance
        return accountList.get(accountID - 1).getBalance();

    }

    // get a list of all of the account information for a particular user
    public List<Account> getAccounts(int userId) {
        return userList.get(userId - 1).getAccounts();
    }

}
