package com.tra.rest.tra.Controller;

import com.tra.rest.tra.Util.CustomerService;
import com.tra.rest.tra.entity.Customer;
import com.tra.rest.tra.exception.RecordExistsException;
import com.tra.rest.tra.exception.RecordNotFoundException;
import com.tra.rest.tra.utility.StatusMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;



import java.util.List;

@RestController
@RequestMapping("/Customer")


public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/Customer/get", method = RequestMethod.GET)
    public List<Customer> findAllCustomer()
    {
        return this.customerService.getAllCustomer();
    }
    @GetMapping("/get/{customer_id}")
    public Customer getCustomer_id(@PathVariable long customer_id)
    {
        try {
            return this.customerService.getCustomer_id(customer_id);
        } catch (RecordNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateCustomer(@RequestBody Customer customer)
    {
        Map<StatusMessages, String> map = new HashMap<>();
        try {
            this.customerService.updateCustomer(customer);
            map.put(StatusMessages.SUCCESS, "Employee updated successfully");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
        } catch (RecordNotFoundException e) {
            map.put(StatusMessages.FAILURE, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
        }
    }
    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable long employeeId)
    {
        Map<StatusMessages , String> map = new HashMap<>();
        try {
            map.put(StatusMessages.SUCCESS, "Employee deleted successfully");
            this.customerService.deleteCustomer(employeeId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
        } catch (RecordNotFoundException e) {
            map.put(StatusMessages.FAILURE, e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
        }
    }

    @PostMapping
    public ResponseEntity<Object> addEmployee(@RequestBody Customer customer)
    {
        try {
            Customer customer1 = this.customerService.insertCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
        } catch (RecordExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
        }
    }
}
