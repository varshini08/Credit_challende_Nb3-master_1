package com.tra.rest.tra.Util;

import com.tra.rest.tra.Repo.CustomerRepository;
import com.tra.rest.tra.entity.Customer;
import com.tra.rest.tra.exception.RecordExistsException;
import com.tra.rest.tra.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public void addCustomer()
    {
        customerRepository.save(
                new Customer("SRI","HARI","MALE","ABC","DEF",999999));
    }
/*
    public Customer insertCustomer(Customer customer) throws RecordExistsException {
        if (customerRepository.existsById(customer.getCustomer_id())) {
            throw new RecordExistsException("Customer with ID " + customer.getCustomer_id() + " already exists");
        }
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }
*/
    public Customer getCustomer_id (long empid) throws RecordNotFoundException {
        return customerRepository.findById(empid)
                .orElseThrow(()->new RecordNotFoundException("Customer with "+empid+" does not exist"));
    }



    public List<Customer> getAllCustomer()
    {
        return this.customerRepository.findAll();
    }
    public void updateCustomer(Customer empToUpdate) throws RecordNotFoundException {
        System.out.println("UPDATE "+empToUpdate.getCustomer_id());
        if(! customerRepository.existsById(empToUpdate.getCustomer_id()))
            throw new RecordNotFoundException("Customer with "+empToUpdate.getCustomer_id()+" does not exist");
        customerRepository.save(empToUpdate);
    }
    public void deleteCustomer(long employeeId) throws RecordNotFoundException {

        if(customerRepository.existsById(employeeId))
            throw new RecordNotFoundException("Customer with "+employeeId+" does not exist");

        customerRepository.deleteById(employeeId);

    }

    public Customer insertCustomer(Customer customer) throws RecordExistsException {
        if(customerRepository.existsById(customer.getCustomer_id()))
            throw new RecordExistsException("Employee with "+customer.getCustomer_id()+"already exists");
        long count = this.customerRepository.count();
        customer.setCustomer_id(count+1);
        Customer savedcustomer = customerRepository.save(customer);
        System.out.printf("There are now %d employees\n", customerRepository.count());
        return  savedcustomer;
    }



}
