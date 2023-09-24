package com.finzly.UtilityBill_PaymentPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class CustomerBillData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billId;
	private String customerName;
	private long customerId;
	private double unitConsumed;
	private Date billStartDate;
	private Date billDueDate;
	private String email;
	private String telephone;
	private String billStatus;

	// constructor
	public CustomerBillData() {

	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public double getUnitConsumed() {
		return unitConsumed;
	}

	public void setUnitConsumed(double unitConsumed) {
		this.unitConsumed = unitConsumed;
	}

	public Date getBillStartDate() {
		return billStartDate;
	}

	public void setBillStartDate(Date billStartDate) {
		this.billStartDate = billStartDate;
	}

	public Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	public CustomerBillData(int billId, String customerName, long customerId, double unitConsumed, Date billStartDate,
			Date billDueDate, String email, String telephone, String billStatus) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.customerId = customerId;
		this.unitConsumed = unitConsumed;
		this.billStartDate = billStartDate;
		this.billDueDate = billDueDate;
		this.email = email;
		this.telephone = telephone;
		this.billStatus = billStatus;
	}

	@Override
	public String toString() {
		return "CustomerBillData [billId=" + billId + ", name=" + customerName + ", customerId=" + customerId
				+ ", unitConsumed=" + unitConsumed + ", billStartDate=" + billStartDate + ", billDueDate=" + billDueDate
				+ ", email=" + email + ", telephone=" + telephone + ", billStatus=" + billStatus + "]";
	}

}
