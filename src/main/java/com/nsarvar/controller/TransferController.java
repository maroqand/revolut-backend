package com.nsarvar.controller;

import com.nsarvar.model.Transfer;
import com.nsarvar.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nsarvar on 12/26/17.
 */
@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping("/webapi/transfers")
    public List<Transfer> transferList(){
        return transferService.getTransfers();
    }

    @RequestMapping("/webapi/transfers/{id}")
    public List<Transfer> getTransferByAccountId(@PathVariable String id){
        return transferService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/webapi/transfers")
    public void newTransfer(@RequestBody Transfer transfer){
        transferService.newTransfer(transfer);
    }
}