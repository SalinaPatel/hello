package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Vendor;
@Repository
@Transactional
public class IVendorImpl implements IVendor {
	@Autowired
	private SessionFactory sf;

	
	public IVendorImpl() {
		System.out.println("in dao constructor");
	}
	@Override
	public Vendor validate(String email, String password) {
		 String jpql="select v from Vendor v where v.email=:em and v.password=:pass";
		 System.out.println("in jpql");
		 return sf.getCurrentSession().createQuery(jpql,Vendor.class).
				 setParameter("em", email).
				 setParameter("pass",password).getSingleResult();
		 }
	@Override
	public String AddVendor(Vendor v) {
	    int num=(int) sf.getCurrentSession().save(v);
	    if(num>=1)
	    {
	    	return "added successfully";
	    }
		return "err in addition of vendor";
	}
	@Override
	public List<Vendor> listVendor() {
		String jpql="select v from Vendor v";
		return sf.getCurrentSession().createQuery(jpql,Vendor.class).getResultList();
	}
	@Override
	public void update(int id, String city) {
		Vendor v=sf.getCurrentSession().get(Vendor.class,id);
		v.setCity(city);
		
	}
	@Override
	public void delete(int id) {
		Vendor v=sf.getCurrentSession().get(Vendor.class, id);
		sf.getCurrentSession().delete(v);
		
	}


}
