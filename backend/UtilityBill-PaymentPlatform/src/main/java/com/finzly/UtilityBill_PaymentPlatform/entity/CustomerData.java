package com.finzly.UtilityBill_PaymentPlatform.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerData {
		@Id
		private long customerId;  //adharcard number
		private String customerName;
		private String telephoneNo;
		private String emailId;
		private String address;
		
		public long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
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
		public CustomerData(int customerId, String customerName, String telephoneNo, String emailId, String address) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.telephoneNo = telephoneNo;
			this.emailId = emailId;
			this.address = address;
		}
		public CustomerData() {
			super();
		}
		@Override
		public String toString() {
			return "CustomerData [customerId=" + customerId + ", customerName=" + customerName + ", telephoneNo="
					+ telephoneNo + ", emailId=" + emailId + ", address=" + address + "]";
		}
		
		
		
}
