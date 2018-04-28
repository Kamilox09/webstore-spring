package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    Map<String, Customer> listOfCustomers;

    public InMemoryCustomerRepository() {
        listOfCustomers = new HashMap<>();
    }

    public void saveCustomer(Customer customer) {
        if (!listOfCustomers.containsKey(customer.getCustomerId())) {
            listOfCustomers.put(customer.getCustomerId(), customer);
        }
    }

    public Customer getCustomer(String customerId) {
        if (listOfCustomers.containsKey(customerId)) {
            return listOfCustomers.get(customerId);
        }
        return null;
    }

    public Boolean isCustomerExist(String customerId) {
        if (listOfCustomers.containsKey(customerId))
            return true;
        return false;
    }
}
