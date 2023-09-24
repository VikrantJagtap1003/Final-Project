package com.finzly.UtilityBill_PaymentPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBill_PaymentPlatform.dao.InvoiceInfoDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.InvoiceInfo;

@Service
public class InvoiceInfoService {
	
	@Autowired
	private InvoiceInfoDao invoiceInfoDao;
	
	public void addInvoiceInfo(InvoiceInfo invoiceinfo) {
		
		invoiceInfoDao.addInvoiceInfo(invoiceinfo);
		
	}

	public InvoiceInfo getInvoiceInfo(int billId) {
		
		return invoiceInfoDao.getInvoiceInfo(billId);
	}

}
