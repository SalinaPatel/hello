package tester;
import static utils.HibernateUtils.*;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.VendorImpl;
import POJO.Vendor;
public class RegisterVendor {

	
	public static void main(String[] args)
	{
	
		
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
		{
			
			System.out.println("inside registervendor");
			
			VendorImpl dao=new VendorImpl();
			//String name, String email, String password, String city, String phoneno
			System.out.println("Enter Vendor Details:");
			
			System.out.println("name, email,  password, city,  phoneno");
			Vendor v=new Vendor(sc.next(),sc.next(),sc.next(),sc.next(),sc.next());
			System.out.println(v);
			System.out.println(dao.Register_Vendor(v));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
