package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {
        Customer janek = new Customer(1, "Janek");
        janek.setAddress("ul. Podwawelska 33");
        janek.setNoOfOrdersMade(2);

        Customer krysia = new Customer(2, "Krystyna");
        krysia.setAddress("ul. Kasztanowska 56");
        krysia.setNoOfOrdersMade(1);

        Customer gracus = new Customer(3, "Gracjan");
        gracus.setAddress("ul. Ratatajaja 7");
        gracus.setNoOfOrdersMade(45);

        listOfCustomers.add(janek);
        listOfCustomers.add(krysia);
        listOfCustomers.add(gracus);
    }

    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
