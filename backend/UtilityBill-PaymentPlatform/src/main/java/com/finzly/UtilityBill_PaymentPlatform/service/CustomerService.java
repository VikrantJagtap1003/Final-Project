package com.finzly.UtilityBill_PaymentPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBill_PaymentPlatform.dao.CustomerDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerData;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;

	public String checkCustomerID(long customerId) {
		CustomerData customerData= customerDao.checkCustomerID(customerId);
		if(customerData==null) {
			return "Invalid User";
		}
		else {
			return "Valid user";
		}
	}

}
