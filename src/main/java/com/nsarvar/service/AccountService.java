package com.nsarvar.service;

import com.nsarvar.model.Account;
import com.nsarvar.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nsarvar on 12/25/17.
 */
@Service
public class AccountService {

    private static List<Account> accounts = new ArrayList<>();

    static {
        accounts.add(new Account("1001", "John", 1000.00));
        accounts.add(new Account("1002", "Tom", 1500.00));
        accounts.add(new Account("1003", "Alex", 2500.00));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getById(String id){
        Account account = accounts.stream().filter(a -> a.getAccountID().equals(id)).findFirst().orElse(null);
        if(account == null){
            throw new EntityNotFoundException("Account not found");
        }
        return account;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void updateTopic(String id, Account account){
        for (int i = 0; i < accounts.size(); i++){
            Account t = accounts.get(i);
            if (t.getAccountID().equals(id)){
                accounts.set(i, account);
                return;
            }
        }
        throw new EntityNotFoundException("Account not found");
    }

    public void deleteAccount(String id) {
        if(!accounts.removeIf(account -> account.getAccountID().equals(id))){
            throw new EntityNotFoundException("Account not found");
        }
    }
}
