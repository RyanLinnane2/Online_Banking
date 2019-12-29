/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Database;

import com.mycompany.online_banking.Model.Account;
import com.mycompany.online_banking.Model.Transaction;
import com.mycompany.online_banking.Model.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author x18145761, x18137695
 */
public class Databse {

    //Create Lists
    private static List<User> userList = new ArrayList<>();
    private static List<Account> accountList = new ArrayList<>();
    private static List<Transaction> transList = new ArrayList<>();
    private static Account account = new Account();
    private static boolean db = true;

    //constructor
    public Databse() {

        if (db) {

            //--------------USER TRANSACTYIONS------------------------//
//       List<Transaction> trans1 = new ArrayList<>();
//       List<Transaction> trans2 = new ArrayList<>();
//               //String date, String description, double newBalance, String debit_credit)
//        Transaction transHistory1 = new Transaction("20-12-19","food",500,"debit");
//        Transaction transHistory2 = new Transaction("21-12-19","food",200,"debit");
            //--------------USER ACCOUNTS--------------------//
            //store user 1's accounts
            List<Account> userOneAccount = new ArrayList<>();
            //store user 2's accounts
            List<Account> userTwoAccount = new ArrayList<>();

            //initialise accounts for user 1 and 2
            //accountID is used to track location of users account in the arraylist1
            Account userOneAccount1 = new Account(1, 123, 5000, 000123);
            Account userTwoAccount1 = new Account(2, 456, 5000, 001024);
            Account userOneaccount2 = new Account(3, 321, 1000, 000124);

            // add initialised accounts to user account arraylist
            userOneAccount.add(userOneAccount1);
            userOneAccount.add(userOneaccount2);
            userTwoAccount.add(userTwoAccount1);

            //add to general overall account db
            accountList.add(userOneAccount1);
            accountList.add(userTwoAccount1);//fixed for indices
            accountList.add(userOneaccount2);


            //------------------CREATE USERS--------------------//
            //initialise users name,address,email,password,userID,List<Account>
            User user1 = new User("John", "Dublin", "john@gmail.com", "password", 1, userOneAccount);
            User user2 = new User("Mark", "Dublin", "mark@gmail.com", "password", 2, userTwoAccount);

            userList.add(user1);
//        accountList = userOneAccount;
            userList.add(user2);
//        accountList = userTwoAccount;

            db = false;
        }

    }

    public static List<User> getUserList() {
        return userList;
    }

    public static List<Account> getAccountList() {
        return accountList;
    }

    public static List<Transaction> getTransList() {
        return transList;
    }

}
