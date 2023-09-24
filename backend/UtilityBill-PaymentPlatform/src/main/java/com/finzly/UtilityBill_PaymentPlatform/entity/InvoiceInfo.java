package com.finzly.UtilityBill_PaymentPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InvoiceInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceId;
	private double beforeDueDateAmout;
	private double afterDueDateAmout;
	private int billId;
	private double ratePerKW;
	
	
	public int getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}
	public double getBeforeDueDateAmout() {
		return beforeDueDateAmout;
	}
	public void setBeforeDueDateAmout(double beforeDueDateAmout) {
		this.beforeDueDateAmout = beforeDueDateAmout;
	}
	public double getAfterDueDateAmout() {
		return afterDueDateAmout;
	}
	public void setAfterDueDateAmout(double afterDueDateAmout) {
		this.afterDueDateAmout = afterDueDateAmout;
	}
	
	public InvoiceInfo(int invoiceId, double beforeDueDateAmout, double afterDueDateAmout, int billid,double rate) {
		super();
		this.invoiceId = invoiceId;
		this.beforeDueDateAmout = beforeDueDateAmout;
		this.afterDueDateAmout = afterDueDateAmout;
		this.billId = billid;
		this.ratePerKW=rate;
	}
	public InvoiceInfo() {
		super();
	}
	
	@Override
	public String toString() {
		return "InvoiceInfo [invoiceId=" + invoiceId + ", beforeDueDateAmout=" + beforeDueDateAmout
				+ ", afterDueDateAmout=" + afterDueDateAmout + ", billId=" + billId + ", ratePerKW=" + ratePerKW + "]";
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public double getRatePerKW() {
		return ratePerKW;
	}
	public void setRatePerKW(double ratePerKW) {
		this.ratePerKW = ratePerKW;
	}
	

}
