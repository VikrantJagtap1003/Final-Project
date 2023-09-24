package com.finzly.UtilityBill_PaymentPlatform.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.UtilityBill_PaymentPlatform.entity.InvoiceInfo;

@Repository
public class InvoiceInfoDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addInvoiceInfo(InvoiceInfo invoiceinfo) {
		Session session=sessionFactory.openSession();
		session.save(invoiceinfo);
		session.beginTransaction().commit();
		
	}

	public InvoiceInfo getInvoiceInfo(int billId) {
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(InvoiceInfo.class);
		criteria.add(Restrictions.eq("billId",billId));
		return (InvoiceInfo) criteria.list().get(0);	
	}
	
}
