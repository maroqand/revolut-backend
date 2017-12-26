package com.nsarvar.service;

import com.nsarvar.model.Account;
import com.nsarvar.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.WebServiceException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nsarvar on 12/25/17.
 */
@Service
public class TransferService {

    @Autowired
    AccountService accountService;

    private List<Transfer> transfers = new ArrayList<>();

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public List<Transfer> getById(String id){
        return transfers.stream().filter(t -> t.getFromAccountID().equals(id) ||
                        t.getToAccountID().equals(id))
                        .collect(Collectors.toList());
    }

    public void newTransfer(Transfer transfer){

        // validation
        if(transfer.getFromAccountID().equals(transfer.getToAccountID())){
            throw new WebServiceException("Sender and receiver are the same account!");
        }
        else if(accountService.getById(transfer.getFromAccountID()) == null){
            throw new WebServiceException("Sender account is not found!");
        }
        else if(accountService.getById(transfer.getToAccountID()) == null){
            throw new WebServiceException("Receiver's account is not found!");
        }
        else if(accountService.getById(transfer.getFromAccountID()).getBalance() - transfer.getAmount() < 0){
            throw new WebServiceException("Balance is not enough!");
        }
        else {
            accountService.getById(transfer.getFromAccountID())
                    .setBalance(accountService.getById(transfer.getFromAccountID()).getBalance()
                            - transfer.getAmount());

            accountService.getById(transfer.getToAccountID())
                    .setBalance(accountService.getById(transfer.getToAccountID()).getBalance()
                            + transfer.getAmount());

        }

        transfer.setDate(new Date());
        transfers.add(transfer);
    }
}
