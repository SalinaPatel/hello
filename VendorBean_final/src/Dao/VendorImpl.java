package Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static utils.HibernateUtils.*;

import java.util.ArrayList;
import java.util.List;

import POJO.Vendor;

public class VendorImpl implements IVendor{

	@Override
	public String Register_Vendor(Vendor V) {
		// TODO Auto-generated method stub
		
		
	SessionFactory sf=getSf();
	
	Session hs=sf.openSession();
	Transaction tx=hs.beginTransaction();
		try {
			
			hs.save(V);//insert data in table
			tx.commit();
			
			
			
		}
		catch(HibernateException e)
		{
			if(tx!=null)
			{
				tx.rollback();
				
			}
			throw e;
			
		}finally {
			if(hs!=null)
			{
				hs.close();
			}
		}
		return "Registered Succesfully";
	}

	@Override
	public List<Vendor> getVendorList() {
		// TODO Auto-generated method stub
		
		
		List<Vendor> vendor=null;
				
		Session hs=getSf().openSession();
		
		Transaction tx=hs.beginTransaction();
		try {
			
			String jpql="select v  from Vendor v";
			
			vendor=hs.createQuery(jpql,Vendor.class).getResultList();
			System.out.println("inside dao get result list"+vendor);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}finally {
			if(hs!=null)
			{
				hs.close();
			}
		}
		
		return vendor;
	}

	@Override
	public String UpdateVendor(String email, String city, String phoneno) {
		// TODO Auto-generated method stub
		String jp=null;
		System.out.println("inside update vendor dao");
	    jp="select v from Vendor v where v.email=:em";
		String msg = "not updated";
		Session hs=getSf().openSession();
		Transaction tx=hs.beginTransaction();
		Vendor v=null;
		try {
			v=hs.createQuery("jp",Vendor.class).setParameter("em",email).getSingleResult();
			
			System.out.println(v);
			if(v!=null)
			{
	              v.setCity(city);
	              v.setPhoneno(phoneno);
	             msg ="updated successfully";
			
			}
			tx.commit();
		}
		catch(HibernateException e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}finally {
			if(hs!=null)
			{
				hs.close();
			}
		}
		
		return msg;
	}

	@Override
	public String Delete(String email, String password) {
		// TODO Auto-generated method stub

		System.out.println("inside delete");
		String jpql="select v from Vendor v where v.email=:em and v.password=:pass";
		String msg="deletion failed";
		Session hs=getSf().getCurrentSession();
		Transaction tx=hs.beginTransaction();
		
		try {
		
			
			Vendor v=hs.createQuery(jpql,Vendor.class).setParameter("em",email).setParameter("pass",password).getSingleResult();
			
			hs.delete(v);
			msg="deleted successfully";
			tx.commit();
			System.out.println(msg);
		}
		catch(HibernateException e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		System.out.println(msg);
		return msg;
	}

	@Override
	public Vendor AuthenticateVendor(String email, String password) {
		// TODO Auto-generated method stub
		String jpql="select v from Vendor v where v.email=:em and v.password=:pass";
		System.out.println("inside dao auth");
		Session hs=getSf().openSession();
		Transaction tx=hs.beginTransaction();
		Vendor v=null;
		try {
			System.out.println("v in dao bf4"+v);
			v=hs.createQuery(jpql,Vendor.class).setParameter("em",email).setParameter("pass",password).getSingleResult();
			System.out.println("v in dao"+v);
			tx.commit();
		}
		catch(RuntimeException e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}
		finally {
			if(hs!=null)
			{
				hs.close();
			}
		}
		return v;
	}

	
	
	
	

}
