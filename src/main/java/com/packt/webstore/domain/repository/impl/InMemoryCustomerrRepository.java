package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customerr;
import com.packt.webstore.domain.repository.CustomerrRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerrRepository implements CustomerrRepository {

    private List<Customerr> listOfCustomers = new ArrayList<Customerr>();

    public InMemoryCustomerrRepository() {
        Customerr janek = new Customerr(1, "Janek");
        janek.setAddress("ul. Podwawelska 33");
        janek.setNoOfOrdersMade(2);

        Customerr krysia = new Customerr(2, "Krystyna");
        krysia.setAddress("ul. Kasztanowska 56");
        krysia.setNoOfOrdersMade(1);

        Customerr gracus = new Customerr(3, "Gracjan");
        gracus.setAddress("ul. Ratatajaja 7");
        gracus.setNoOfOrdersMade(45);

        listOfCustomers.add(janek);
        listOfCustomers.add(krysia);
        listOfCustomers.add(gracus);
    }

    public List<Customerr> getAllCustomers() {
        return listOfCustomers;
    }
}
