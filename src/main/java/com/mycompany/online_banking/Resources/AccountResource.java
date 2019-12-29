/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Resources;

import com.google.gson.Gson;
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
import javax.ws.rs.core.Response;

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
    public Response createAccount( @PathParam("userId") int id) {
        Gson gson = new Gson();
        Account a =  accountServices.createAccount(new Account(), id);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(a)).build();
    }

    @GET
    @Path("/fetch/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccounts(@PathParam("userId") int id) {
        Gson gson = new Gson();
        return Response.status(Response.Status.CREATED).entity(gson.toJson(accountServices.getAccounts(id))).build();
    }

    // Enter account number to return balance of that account
    // curl -v -X POST http://localhost:49000/api/accounts/fetch/000123
    @GET
    @Path("/fetch/balance/{accountID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBalance(@PathParam("accountID") int accountID) {
        Gson gson = new Gson();
        return Response.status(Response.Status.CREATED).entity(gson.toJson(accountServices.getBalance(accountID))).build();
    }

}
