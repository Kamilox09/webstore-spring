package com.packt.webstore.service.impl;


import com.packt.webstore.domain.Customerr;
import com.packt.webstore.domain.repository.CustomerrRepository;
import com.packt.webstore.service.CustomerrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerrServiceImpl implements CustomerrService {

    @Autowired
    CustomerrRepository customerrRepository;

    public List<Customerr> getAllCustomers() {
        return customerrRepository.getAllCustomers();
    }
}
