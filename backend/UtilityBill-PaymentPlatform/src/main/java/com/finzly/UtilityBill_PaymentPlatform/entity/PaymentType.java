package com.finzly.UtilityBill_PaymentPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String paymentMode;
	private double discount;
	
	
	
	public PaymentType() {
		super();
	}
	public PaymentType(int id, String paymentMode, double discount) {
		super();
		this.id = id;
		this.paymentMode = paymentMode;
		this.discount = discount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "PaymentType [id=" + id + ", paymentMode=" + paymentMode + ", discount=" + discount + "]";
	}
	
	
	
	

}
