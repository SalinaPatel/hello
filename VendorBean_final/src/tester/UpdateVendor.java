package tester;

import org.hibernate.SessionFactory;

import Dao.VendorImpl;

import static utils.HibernateUtils.*;

import java.util.Scanner;
public class UpdateVendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in)){
			
			
			VendorImpl dao=new VendorImpl();
			System.out.println("Enter Vendor id ,city and phone no");
			//String msg=dao.UpdateVendor(sc.nextInt(), sc.next(), sc.next());
           // System.out.println(msg);
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
