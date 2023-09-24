package com.finzly.UtilityBill_PaymentPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.UtilityBill_PaymentPlatform.dao.EmployeeDao;
import com.finzly.UtilityBill_PaymentPlatform.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public String addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

}
