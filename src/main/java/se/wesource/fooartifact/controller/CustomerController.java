package se.wesource.fooartifact.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.wesource.fooartifact.exception.CustomNotFoundException;
import se.wesource.fooartifact.model.Customer;
import se.wesource.fooartifact.service.CustomerService;
import se.wesource.otherspringbootservice.model.Other;
import se.wesource.otherspringbootservice.service.OtherService;

@RestController
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OtherService otherService;

    @RequestMapping(value="/customer/{name}")
    public Customer findCustomerByName(@PathVariable("name")String name){

        Customer cust = customerService.findCustomerByName(name);

        if(null == cust){
            throw new CustomNotFoundException("Not found customer with name is " + name);
        }

        return cust;
    }

    @RequestMapping(value="/other/{name}")
    public Other findOther(@PathVariable("name")String name){
        log.info("findOther in other! ");
        Other other = otherService.findOtherByName(name);

        return other;
    }
}
