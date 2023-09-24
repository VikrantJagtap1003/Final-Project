package com.finzly.UtilityBill_PaymentPlatform.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BillPaymentDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String paymentType;
	private double billAmount;
	private Date paidDate;
	private int billId;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public BillPaymentDetails(int paymentId, String paymentType, double billAmount, Date paidDate, int billId) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.billAmount = billAmount;
		this.paidDate = paidDate;
		this.billId = billId;
	}
	public BillPaymentDetails() {
		super();
	}
	@Override
	public String toString() {
		return "BillPaymentDetails [paymentId=" + paymentId + ", paymentType=" + paymentType + ", billAmount="
				+ billAmount + ", paidDate=" + paidDate + ", billId=" + billId + "]";
	}
	
	

}
