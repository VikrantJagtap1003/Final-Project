package com.finzly.UtilityBill_PaymentPlatform.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerBillData;

@Repository
public class CustomerBillDataDao {
	@Autowired
	SessionFactory sessionFactory;

	public CustomerBillData addCustomerBill(CustomerBillData customerBillData) {

		Session session = sessionFactory.openSession();
		int id=(int) session.save(customerBillData);
		session.beginTransaction().commit();
		return session.get(CustomerBillData.class,id);	
	}

	public List<CustomerBillData> getPaidBills() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CustomerBillData.class);
		criteria.add(Restrictions.eq("billStatus", "paid"));
		return criteria.list();

	}

	public List<CustomerBillData> getUnpaidBills() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CustomerBillData.class);
		criteria.add(Restrictions.eq("billStatus", "pending"));
		return criteria.list();
	}

	public List<CustomerBillData> getCustomerBillDataById(long customerId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(CustomerBillData.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		return criteria.list();
	}

	public void payBill(CustomerBillData customerBillData) {
		Session session = sessionFactory.openSession();
		session.update(customerBillData);
		session.beginTransaction().commit();
		session.close();

	}

	public List<CustomerBillData> uploadCustomerBillData(List<CustomerBillData> customerBillDatas) {
		List<CustomerBillData> addedDatas=new ArrayList<>();
		for (CustomerBillData data : customerBillDatas) {
			Session session = sessionFactory.openSession();
			int id=(int)session.save(data);
			session.beginTransaction().commit();
			addedDatas.add(session.get(CustomerBillData.class,id));
		}
		return addedDatas ;
	}

	public void payBillOnline(CustomerBillData customerBillData) {
		Session session = sessionFactory.openSession();
		session.update(customerBillData);
		session.beginTransaction().commit();
		session.close();

	}

	public CustomerBillData getSpecificBill(int billid) {
		Session session = sessionFactory.openSession();
		
		CustomerBillData data= session.get(CustomerBillData.class,billid);
		return data;
		
	}

}
