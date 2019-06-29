package tester;

import static utils.HibernateUtils.*;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.VendorImpl;
import POJO.Vendor;

public class GetDetails {
public static void main(String[] agrs)
{
	try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
	{
		
		System.out.println("inside getdetails");
		VendorImpl dao=new VendorImpl();
		List<Vendor> vend=dao.getVendorList();
	//	System.out.println(vend);
		for(Vendor v:vend)
		{
			System.out.println(v);
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	
}
	
}
