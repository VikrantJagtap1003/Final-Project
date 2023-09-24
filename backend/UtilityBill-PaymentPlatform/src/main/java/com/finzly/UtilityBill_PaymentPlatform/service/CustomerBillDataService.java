 package com.finzly.UtilityBill_PaymentPlatform.service;

import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finzly.UtilityBill_PaymentPlatform.dao.BillPaymentDetailsDao;
import com.finzly.UtilityBill_PaymentPlatform.dao.CustomerBillDataDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.BillPaymentDetails;
import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerBillData;
import com.finzly.UtilityBill_PaymentPlatform.entity.InvoiceInfo;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@Service
public class CustomerBillDataService {
	
	@Autowired
	private CustomerBillDataDao customerBillDataDao;
	@Autowired
	private BillPaymentDetailsDao billPaymentDetailsService;
	@Autowired
	private PaymentTypeService paymentTypeService;
	@Autowired
	private InvoiceInfoService invoiceInfoService;
	

	public CustomerBillData addCustomerBill(CustomerBillData customerBillData) {
		
		CustomerBillData addedBillData=customerBillDataDao.addCustomerBill(customerBillData);
		
		InvoiceInfo invoiceinfo=new InvoiceInfo();
		invoiceinfo.setBillId(addedBillData.getBillId());
		invoiceinfo.setRatePerKW(40.5);
		double amount=addedBillData.getUnitConsumed()*41.5;
		double beforeDueDate=amount-((amount*paymentTypeService.getDiscount("duedate"))/100);
		invoiceinfo.setBeforeDueDateAmout(beforeDueDate);
		invoiceinfo.setAfterDueDateAmout(amount);
		
		invoiceInfoService.addInvoiceInfo(invoiceinfo);
		return addedBillData;
	}
	
	public List<CustomerBillData> getPaidBills() {
		
		return customerBillDataDao.getPaidBills();
	}

	public List<CustomerBillData> getUnpaidBills() {
		return customerBillDataDao.getUnpaidBills();
	}

	public List<CustomerBillData> getCustomerBillDataById(long customerId) {
		return customerBillDataDao.getCustomerBillDataById(customerId);
	}

	public String payBill(CustomerBillData customerBillData) {
		
		customerBillData.setBillStatus("paid");
		customerBillDataDao.payBill(customerBillData);
		
		BillPaymentDetails billPayment=new BillPaymentDetails();
		billPayment.setBillId(customerBillData.getBillId());
		java.util.Date currentDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		billPayment.setPaidDate(sqlDate);
		billPayment.setPaymentType("cash");
		
		double payAmount=customerBillData.getUnitConsumed()*41.50;
		double discount=paymentTypeService.getDiscount(billPayment.getPaymentType());
		
		if(sqlDate.before(customerBillData.getBillDueDate()))
		{
			discount=discount+paymentTypeService.getDiscount("duedate");
			payAmount= payAmount-((payAmount*discount)/100);
		}
		billPayment.setBillAmount(payAmount);
		return billPaymentDetailsService.addTransaction(billPayment);
		
	}

	public List<CustomerBillData> uploadCustomerBillData(MultipartFile file) throws Exception{
		
		
		List<CustomerBillData> customerBillDatas = new ArrayList<>();
		InputStream inputStream = file.getInputStream();
		CsvParserSettings settings = new CsvParserSettings();
		settings.setHeaderExtractionEnabled(true);
		CsvParser parser = new CsvParser(settings);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		
		parseAllRecords.forEach(record -> {
			
			CustomerBillData customerBillData = new CustomerBillData();
			customerBillData.setCustomerName(record.getString("customer_name"));
			customerBillData.setCustomerId(Long.parseLong(record.getString("customer_id")));
			customerBillData.setUnitConsumed(Double.parseDouble(record.getString("unit_consumed")));
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String billStartDate = record.getString("bill_start_date");
				java.util.Date utilDate = dateFormat.parse(billStartDate);
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				customerBillData.setBillStartDate(sqlDate);
				String billDueDate = record.getString("bill_due_date");
				java.util.Date utilDate1 = dateFormat.parse(billDueDate);
				java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
				customerBillData.setBillDueDate(sqlDate1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			customerBillData.setEmail(record.getString("email"));
			customerBillData.setTelephone(record.getString("telephone"));
			customerBillData.setBillStatus(record.getString("bill_status"));
			
			customerBillDatas.add(customerBillData);
			
		});
		
		List<CustomerBillData> addedDatas= customerBillDataDao.uploadCustomerBillData(customerBillDatas);
		
		for(CustomerBillData data:addedDatas) {
			InvoiceInfo invoiceinfo=new InvoiceInfo();
			invoiceinfo.setBillId(data.getBillId());
			invoiceinfo.setRatePerKW(40.5);
			double amount=data.getUnitConsumed()*41.50;
			double beforeDueDate=amount-((amount*paymentTypeService.getDiscount("duedate"))/100);
			invoiceinfo.setBeforeDueDateAmout(beforeDueDate);
			invoiceinfo.setAfterDueDateAmout(amount);
			invoiceInfoService.addInvoiceInfo(invoiceinfo);
		}
		
		return addedDatas;
		
	}

	public String payBillOnline(CustomerBillData customerBillData) {
		customerBillData.setBillStatus("paid");
		customerBillDataDao.payBillOnline(customerBillData);
		
		BillPaymentDetails billPayment=new BillPaymentDetails();
		billPayment.setBillId(customerBillData.getBillId());
		java.util.Date currentDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
		billPayment.setPaidDate(sqlDate);
		billPayment.setPaymentType("online");
		
		double payAmount=customerBillData.getUnitConsumed()*45.5;
		double discount=paymentTypeService.getDiscount(billPayment.getPaymentType());
		
		if(sqlDate.before(customerBillData.getBillDueDate()))
		{
			discount=discount+paymentTypeService.getDiscount("duedate");
			payAmount= payAmount-(payAmount*discount)/100;
		}
		billPayment.setBillAmount(payAmount);
		return billPaymentDetailsService.addTransaction(billPayment);
	}

	public CustomerBillData getSpecificBill(int billid) {
		return customerBillDataDao.getSpecificBill(billid);
		
	}

}
