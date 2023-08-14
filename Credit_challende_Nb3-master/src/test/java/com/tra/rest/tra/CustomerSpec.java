package com.tra.rest.tra;

import com.tra.rest.tra.Repo.CustomerRepository;
import com.tra.rest.tra.Util.CustomerService;
import com.tra.rest.tra.entity.Customer;
import com.tra.rest.tra.exception.RecordExistsException;
import com.tra.rest.tra.exception.RecordNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@SpringBootTest
public class CustomerSpec {
    @Mock
    CustomerRepository repo;
    @InjectMocks
    CustomerService customerService;
    List<Customer> collection;
    Customer Customer1, Customer2, Customer3;

    @BeforeEach
    public void firstBeforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeEach
    public void befEach() {
        Customer1 = new Customer("Customer1", "Murray", "F","Advertising", "12/23/1974",21);
        Customer2 = new Customer("Customer2", "Rogers", "M","VideoEditor", "09/12/1973",22);
        Customer2 = new Customer("Customer3", "Ranish", "M","EventHead", "04/24/1966",23);

        collection = Arrays.asList(Customer1, Customer2, Customer3);
    }

    @Test
    public void getAllCustomer() {

        when(repo.findAll()).thenReturn(collection);

        assertEquals(3, customerService.getAllCustomer().size());

        assertEquals(collection, customerService.getAllCustomer());
    }

    @Test
    public void addCustomerSpec() throws RecordExistsException {
        when(repo.save(Customer1)).thenReturn(Customer1);

        Customer newlyadded = customerService.insertCustomer(Customer1);
        assertEquals(newlyadded, Customer1);
        assertEquals(4, collection.size() + 1);
    }
    @Test
    public void getCustomerSpec() throws RecordNotFoundException {

        when(repo.findById(21L)).thenReturn(Optional.ofNullable(Customer1));
        Customer retval = customerService.getCustomer_id(21);
        assertEquals(Customer1,retval);
    }



}
