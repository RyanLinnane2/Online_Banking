/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Services;

import com.mycompany.online_banking.Database.Databse;
import com.mycompany.online_banking.Model.User;
import com.mycompany.online_banking.Model.Account;
import com.mycompany.online_banking.Model.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ryan
 */
public class UserService {

    private List<User> userList = Databse.getUserList();
    private Databse userDB = new Databse();

    public User getUserById(int userId) {
        return userList.get(userId - 1);
    }

    public User createUser(User u) {
        u.setUserID(userList.size() + 1);
        userList.add(u);
        return u;
    }

    public List<User> getAllUsers() {
        return userDB.getUserList();
    }
}
