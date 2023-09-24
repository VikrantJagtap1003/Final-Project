package com.finzly.UtilityBill_PaymentPlatform.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finzly.UtilityBill_PaymentPlatform.dao.BillPaymentDetailsDao;
import com.finzly.UtilityBill_PaymentPlatform.dao.CustomerBillDataDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.BillPaymentDetails;
import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerBillData;

@Service
public class BillPaymentDetailsService {

	@Autowired
	private BillPaymentDetailsDao billPaymentDetailsDao;
	@Autowired
	private CustomerBillDataDao customerBillDataDao;

	public List<BillPaymentDetails> viewCashPayments() {
		return billPaymentDetailsDao.viewCashPayments();

	}

	public String addTransaction(BillPaymentDetails billPayment) {

		return billPaymentDetailsDao.addTransaction(billPayment);
	}

	public List<BillPaymentDetails> getTransactions(long customerId) {
		List<CustomerBillData> billDatas = customerBillDataDao.getCustomerBillDataById(customerId);
		List<BillPaymentDetails> successfulTransactions = new ArrayList<>();
		for (CustomerBillData customerBillData : billDatas) {
			if (customerBillData.getBillStatus().equals("paid")) {
				List<BillPaymentDetails> paymentDetails = billPaymentDetailsDao
						.getPaymentData(customerBillData.getBillId());
				if (paymentDetails.size() > 0) {
					successfulTransactions.add(paymentDetails.get(0));
				}

			}
		}
		return successfulTransactions;
	}
}
