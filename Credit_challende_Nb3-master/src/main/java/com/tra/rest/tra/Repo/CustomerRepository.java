package com.tra.rest.tra.Repo;

import com.tra.rest.tra.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer,Long> {

    Page<Customer> findAll(Pageable pageable);
}
