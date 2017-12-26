package com.nsarvar.controller;

import com.nsarvar.model.Transfer;
import com.nsarvar.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nsarvar on 12/26/17.
 * @RestController is the base annotation for classes that handle REST operations.
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

    /*
    @RequestMapping("/webapi/transfers/{id}")
    public ResponseEntity<List<Transfer>> getTransferByAccountId(@PathVariable String id){
        List<Transfer> transfers = transferService.getById(id);
        if(transfers.size() == 0){
            CustomError error = new CustomError(4, "Account #" + id + " not found");
            return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Transfer>>(transfers, HttpStatus.OK);

    }
     */

    @RequestMapping(method = RequestMethod.POST, value = "/webapi/transfers")
    public void newTransfer(@RequestBody Transfer transfer){
        transferService.newTransfer(transfer);
    }
}