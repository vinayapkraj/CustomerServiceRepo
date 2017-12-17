package com.alten.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alten.service.CustomerService;
import com.alten.dto.Customer;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@EnableAutoConfiguration
public class CustomerController {
	

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/addCustomer",method=RequestMethod.GET)
    public void addCustomer() {
		customerService.pushCustomerData();
        
    }
	
	@RequestMapping(value="/getCustomerDetails/{custID}",method=RequestMethod.GET)
    public Customer getCustomer(@PathVariable int custID) {
    	return customerService.getCustomerByID(custID);
        
    }
	
}