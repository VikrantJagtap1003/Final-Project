package com.finzly.UtilityBill_PaymentPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBill_PaymentPlatform.service.CustomerService;

@RestController
@CrossOrigin()
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("checkCustomerId/{customerId}")
	public String checkCustomerID( @PathVariable long customerId) {
		
		return customerService.checkCustomerID(customerId);
	}
}
