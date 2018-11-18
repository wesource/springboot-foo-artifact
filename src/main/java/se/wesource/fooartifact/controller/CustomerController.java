package se.wesource.fooartifact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.wesource.fooartifact.exception.CustomNotFoundException;
import se.wesource.fooartifact.model.Customer;
import se.wesource.fooartifact.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value="/customer/{name}")
    public Customer findCustomerByName(@PathVariable("name")String name){

        Customer cust = customerService.findCustomerByName(name);

        if(null == cust){
            throw new CustomNotFoundException("Not found customer with name is " + name);
        }

        return cust;
    }
}
