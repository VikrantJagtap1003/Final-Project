package com.finzly.UtilityBill_PaymentPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBill_PaymentPlatform.entity.OTP;
import com.finzly.UtilityBill_PaymentPlatform.service.OTPService;

@RestController
@CrossOrigin
public class OTP_Controller {
	@Autowired
	private OTPService otpService;
	
	@GetMapping("getOTP")
	public String generateOTP(){
		return otpService.generateOTP();
	}
	
	@PostMapping("addOTP")
	public String addOTP(@RequestBody OTP otp) {
		return otpService.addOTP(otp);
	}

}
