/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Resources;

import com.mycompany.online_banking.Services.AccountServices;
import com.mycompany.online_banking.Model.Account;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author x18145761, x18137695
 */
@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    //User user = new User();
    AccountServices accountServices = new AccountServices();

    @POST
    @Path("/createAccount/{userId}")
    public Account createAccount(Account account, @PathParam("userId") int id) {
        return accountServices.createAccount(account, id);
    }

    @GET
    @Path("/fetch/{userId}")
    @Produces(MediaType.APPLICATION_XML)
    public List<Account> getAccounts(@PathParam("userId") int id) {
        return accountServices.getAccounts(id);
    }

    // Enter account number to return balance of that account
    // curl -v -X POST http://localhost:49000/api/accounts/fetch/000123
    @GET
    @Path("/fetch/balance/{accountID}")
    @Produces("text/plain")
    public double getBalance(@PathParam("accountID") int accountID) {
        return accountServices.getBalance(accountID);
    }

}
