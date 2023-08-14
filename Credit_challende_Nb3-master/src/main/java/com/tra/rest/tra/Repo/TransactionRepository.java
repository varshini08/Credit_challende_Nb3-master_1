package com.tra.rest.tra.Repo;

import com.tra.rest.tra.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction,Long> {

    //List<Transaction> findEmployeesByGender(String gender);
   // Page<Transaction> findTransactionByDoshGreaterThan(double salary, Pageable pageable);
    Page<Transaction> findAll(Pageable pageable);
    List<Transaction> findTransactionByState(String region);
    List<Transaction> findTransactionByGender(String gender);
    @Query("{'amt' : {$gte : ?0, $lte : ?1}}")
    List<Transaction> findTransactionInAmtRange(double from, double to);

}
