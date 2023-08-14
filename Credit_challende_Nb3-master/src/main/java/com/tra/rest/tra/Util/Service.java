package com.tra.rest.tra.Util;


import com.tra.rest.tra.Repo.TransactionRepository;
import com.tra.rest.tra.entity.Customer;
import com.tra.rest.tra.entity.Transaction;
import com.tra.rest.tra.exception.RecordExistsException;
import com.tra.rest.tra.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
@Autowired
private TransactionRepository repository;

@Bean
public void addTransaction()
{
    repository.save(
            new Transaction("a",100d,99999999L,1,"b","c",500L,"e","F","g","h","MALE","10052002","5"));
}

    public List<Transaction> getAllTransactions()
    {
        return this.repository.findAll();
    }



    public Transaction getTransaction_id (long empid) throws RecordNotFoundException {
        return repository.findById(empid)
                .orElseThrow(()->new RecordNotFoundException("Customer with "+empid+" does not exist"));
    }
    // Get all employees by region.
    public List<Transaction> getAllTransactionByState(String region) {
        return this.repository.findTransactionByState(region);
    }
    // Get all employees by salary range.
    public List<Transaction> getAllTransactionByAmtRange(double from, double to) {
        return this.repository.findTransactionInAmtRange(from,  to);
    }
    public List<Transaction> getAllTransactionByGender(String gender) {
        return this.repository.findTransactionByGender(gender);
    }



}
