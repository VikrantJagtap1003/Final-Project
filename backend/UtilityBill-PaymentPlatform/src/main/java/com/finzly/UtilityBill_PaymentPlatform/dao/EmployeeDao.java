package com.finzly.UtilityBill_PaymentPlatform.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.UtilityBill_PaymentPlatform.entity.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public String addEmployee(Employee employee) {
		Session session=sessionFactory.openSession();
		session.save(employee);
		session.beginTransaction().commit();
		
		return "Employee data saved successfully";
	}

}
