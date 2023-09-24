package com.finzly.UtilityBill_PaymentPlatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBill_PaymentPlatform.dao.PaymentTypeDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.PaymentType;

@Service
public class PaymentTypeService {
	@Autowired
	PaymentTypeDao paymentTypeDao;

	public String addPaymentType(PaymentType paymentType) {
		return paymentTypeDao.addPaymentType(paymentType);
	}

	public double getDiscount(String paymentMode) {
		List<PaymentType> dataList= paymentTypeDao.getDiscount(paymentMode);
		return dataList.get(0).getDiscount();
		
	}

}
