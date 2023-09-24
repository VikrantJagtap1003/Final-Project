package com.finzly.UtilityBill_PaymentPlatform.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.finzly.UtilityBill_PaymentPlatform.dao.OTPDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.OTP;

@Service
public class OTPService {
	
	@Autowired
	private OTPDao otpDao;

	public  String generateOTP() {
		
		List<OTP> ListotpList=otpDao.generateOTP();
		Random random=new Random();
		int otpindex=random.nextInt(ListotpList.size());
		OTP selectedOtp= ListotpList.get(otpindex);
		
		return selectedOtp.getOtp();
		 
	}

	public String addOTP(OTP otp) {
		
		return otpDao.addOTP(otp);
	}
	
	
}
