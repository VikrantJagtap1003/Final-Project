package com.finzly.UtilityBill_PaymentPlatform.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBill_PaymentPlatform.entity.PaymentType;
import com.finzly.UtilityBill_PaymentPlatform.service.PaymentTypeService;

@RestController
@RequestMapping("/paymentType")
public class PaymentTypeController {
	
	@Autowired
	PaymentTypeService paymentTypeService;
	
	
	@PostMapping("/add-paymentType")
	public String addPaymentType(@RequestBody PaymentType paymentType) {
		return paymentTypeService.addPaymentType(paymentType);
		
	}
	
	@GetMapping("/discount/{paymentMode}")
	public double getDiscount(@PathVariable String paymentMode) {
		return paymentTypeService.getDiscount(paymentMode);
	}
	

}
