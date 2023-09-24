package com.finzly.UtilityBill_PaymentPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBill_PaymentPlatform.entity.BillPaymentDetails;
import com.finzly.UtilityBill_PaymentPlatform.service.BillPaymentDetailsService;

@RestController
@CrossOrigin()
public class BillPaymentDetailsController {
	
	@Autowired
	private BillPaymentDetailsService billPaymentDetailsService;
	
	@GetMapping("/viewCashPayments")
	public List<BillPaymentDetails> viewCashPayments() {
		return billPaymentDetailsService.viewCashPayments();
	}
	@GetMapping("getTransaction/{customerId}")
	public List<BillPaymentDetails> getTransactions(@PathVariable long customerId ) {
		return billPaymentDetailsService.getTransactions(customerId);
	}
	
	
	
	
	
		
}
