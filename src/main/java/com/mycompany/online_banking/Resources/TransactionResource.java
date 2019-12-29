/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.online_banking.Resources;

import com.google.gson.Gson;
import com.mycompany.online_banking.Database.Databse;
import com.mycompany.online_banking.Model.Account;
import com.mycompany.online_banking.Model.Transaction;
import com.mycompany.online_banking.Services.TransactionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author x18145761, x18137695, x18160786
 */
@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    TransactionService tService = new TransactionService();
    // private List<Account> accountList = new Databse().getAccountList();

    //curl -v -X POST http://localhost:49000/api/transactions/2/lodge
    /* In Postman...Body -> raw
     *   {
     *   "newBalance":4000.0
     *   "description":"monthly salary"
     *   }
     */
    @POST
    @Path("/{accId}/lodge/{amt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response lodgeMoney(@PathParam("accId") int id, @PathParam("amt") double amount) {
        Gson gson = new Gson();
        Transaction transaction = new Transaction();
        //double amount = transaction.getNewBalance();
        String description = transaction.getDescription();
        String message = tService.lodgeMoney(id, amount, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(message)).build();
    }

    @POST
    @Path("/{sortCode}/{accountNum}/lodge/")
    @Produces(MediaType.APPLICATION_XML)
    public Response lodgeMoney2(@PathParam("sortCode") int sortCode, @PathParam("accountNum") int accountNum, Transaction transaction) {
        double amount = transaction.getNewBalance();
        String description = transaction.getDescription();
        String message = tService.lodgeMoney2(sortCode, accountNum, amount, description);
        return Response.status(Response.Status.CREATED).entity(message).build();
    }

    //curl -v -X POST http://localhost:49000/api/transactions/2/withdraw
    /* In Postman...Body -> raw
     *   {
     *   "newBalance":100.0
     *   "description":"ATM"
     *   }
     */
    @POST
    @Path("/{accId}/withdraw/{amt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response withdrawMoney(@PathParam("accId") int id, @PathParam("amt") double amount) {
        Gson gson = new Gson();
        Transaction transaction = new Transaction();
        //double amount = transaction.getNewBalance();
        String description = transaction.getDescription();
        String message = tService.withdrawMoney(id, amount, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(message)).build();
    }

    @POST
    @Path("/{sortCode}/{accountNum}/withdraw")
    @Produces(MediaType.APPLICATION_XML)
    public Response withdrawMoney2(@PathParam("sortCode") int sortCode, @PathParam("accountNum") int accountNum, Transaction transaction) {
        double amount = transaction.getNewBalance();
        String description = transaction.getDescription();
        String message = tService.withdrawMoney2(sortCode, accountNum, amount, description);
        return Response.status(Response.Status.CREATED).entity(message).build();
    }

    //curl -v -X POST http://localhost:49000/api/transactions/2/3/transfer
    /* In Postman...Body -> raw
     *   {
     *   "newBalance":4000.0
     *   "description":"debt payment"
     *   }
     */
    @POST
    @Path("/{transferFrom}/{transferTo}/transfer/{amt}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response transfer(@PathParam("transferFrom") int id1, @PathParam("transferTo") int id2, @PathParam("amt") double amount) {
        Gson gson = new Gson();
        Transaction transaction = new Transaction();
        //double amount = transaction.getNewBalance();
        String description = transaction.getDescription();
        String message = tService.transferMoney(id1, id2, amount, description);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(message)).build();
    }

    @POST
    @Path("/{FromSortCode}/{FromAccNum}/{ToSortCode}/{ToAccNum}/transfer")
    @Produces(MediaType.APPLICATION_XML)
    public Response transfer2(@PathParam("FromSortCode") int sortCode1, @PathParam("FromAccNum") int accountNum1, @PathParam("ToSortCode") int sortCode2, @PathParam("ToAccNum") int accountNum2, Transaction transaction) {
        double amount = transaction.getNewBalance();
        String description = transaction.getDescription();
        String message = tService.transferMoney2(sortCode1, accountNum1, sortCode2, accountNum2, amount, description);
        return Response.status(Response.Status.CREATED).entity(message).build();
    }
}
