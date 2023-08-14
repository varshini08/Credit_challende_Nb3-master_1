package com.tra.rest.tra.Controller;


import com.tra.rest.tra.Util.Service;
import com.tra.rest.tra.entity.Customer;
import com.tra.rest.tra.entity.Transaction;
import com.tra.rest.tra.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


public class TransactionRestController {
    @Autowired
private Service service;
    @RequestMapping(path = "/Transaction/get", method = RequestMethod.GET)
    public List<Transaction> findAllTransaction()
    {
        return this.service.getAllTransactions();
    }

    @GetMapping("/Transaction/{Transaction_id}")
    public Transaction getTransaction_id(@PathVariable long Transaction_id)
    {
        try {
            return this.service.getTransaction_id(Transaction_id);
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/Transaction/state")
    public List<Transaction> getAllTransaction(@RequestParam(required = false) String region)
    {
        if(region == null)
            return service.getAllTransactions();
        return service.getAllTransactionByState(region);
    }

    @GetMapping("/Transaction/gender")
    public List<Transaction> getAllTransactiongender(@RequestParam(required = false) String gender)
    {
        if(gender == null)
            return service.getAllTransactions();
        return service.getAllTransactionByGender(gender);
    }

    @GetMapping("/Transaction/amt")
    public List<Transaction> getAllTransaction(@RequestParam(required = false) double from ,double to)
    {
        return service.getAllTransactionByAmtRange(from , to);
    }





}
