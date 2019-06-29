package tester;

import static utils.HibernateUtils.getSf;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import Dao.VendorImpl;
public class DeleteVendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try(SessionFactory sf=getSf();Scanner sc=new Scanner(System.in))
{
	VendorImpl dao=new VendorImpl();
	System.out.println("enter email and passwod");
	String msg=dao.Delete(sc.next(),sc.next());
	System.out.println(msg);
	
}
catch(Exception e)
{
	
}
	}

}
