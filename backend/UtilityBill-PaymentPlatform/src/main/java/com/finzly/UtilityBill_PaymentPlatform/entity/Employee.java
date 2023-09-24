package com.finzly.UtilityBill_PaymentPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private long employeeId;  //adharcard number
	private String employeeName;
	private String telephoneNo;
	private String emailId;
	private String address;
	
	
	
	
	public Employee() {
		super();
	}
	
	
	public Employee(long employeeId, String employeeName, String telephoneNo, String emailId, String address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.telephoneNo = telephoneNo;
		this.emailId = emailId;
		this.address = address;
	}


	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getTelephoneNo() {
		return telephoneNo;
	}
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", telephoneNo=" + telephoneNo
				+ ", emailId=" + emailId + ", address=" + address + "]";
	}
	
	
	
	

}
