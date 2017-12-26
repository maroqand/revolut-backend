package com.nsarvar.controller;

import com.nsarvar.model.Account;
import com.nsarvar.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by nsarvar on 12/25/17.
 */

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/webapi/accounts")
    public List<Account> allAccounts(){
        return accountService.getAccounts();
    }

    @RequestMapping("/webapi/accounts/{id}")
    public Account getAccount(@PathVariable String id) {


        return accountService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/webapi/accounts")
    public void addTopic(@RequestBody Account account){
        accountService.addAccount(account);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/webapi/accounts/{id}")
    public void update(@RequestBody Account account, @PathVariable String id){
        accountService.updateTopic(id, account);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/webapi/accounts/{id}")
    public void delete(@PathVariable String id){
        accountService.deleteAccount(id);
    }
}
