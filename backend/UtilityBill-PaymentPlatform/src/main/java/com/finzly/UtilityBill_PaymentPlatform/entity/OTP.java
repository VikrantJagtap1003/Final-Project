package com.finzly.UtilityBill_PaymentPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OTP {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int optId;
	
	private String otp;

	private boolean isInUse;
	
	public OTP(int optId, String otp, boolean isInUse) {
		super();
		this.optId = optId;
		this.otp = otp;
		this.isInUse = isInUse;
	}
	

	public OTP() {
		super();
	}


	public int getOptId() {
		return optId;
	}

	public void setOptId(int optId) {
		this.optId = optId;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isInUse() {
		return isInUse;
	}

	public void setInUse(boolean isInUse) {
		this.isInUse = isInUse;
	}

}
