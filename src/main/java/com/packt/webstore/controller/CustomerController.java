package com.packt.webstore.controller;


import com.packt.webstore.service.CustomerrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    @Autowired
    CustomerrService customerrService;

    @RequestMapping("/customers")
    public String listofCustomers(Model model) {
        model.addAttribute("customers", customerrService.getAllCustomers());
        return "customers";
    }
}
