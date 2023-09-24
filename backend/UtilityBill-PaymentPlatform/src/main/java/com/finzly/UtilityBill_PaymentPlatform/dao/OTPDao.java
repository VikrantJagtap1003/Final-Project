package com.finzly.UtilityBill_PaymentPlatform.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.UtilityBill_PaymentPlatform.entity.OTP;

@Repository
public class OTPDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<OTP> generateOTP() {
		
		Session otpSession=sessionFactory.openSession();
		Criteria otpCriteria=otpSession.createCriteria(OTP.class);
		otpCriteria.add(Restrictions.eq("isInUse",false));
		return otpCriteria.list();
		
	}

	public String addOTP(OTP otp) {
		
		Session otpSession=sessionFactory.openSession();
		otpSession.save(otp);
		otpSession.beginTransaction().commit();
		return "Data added successfully";
		
	}

}
