package Bean;

import java.util.List;

import Dao.VendorImpl;
import POJO.Vendor;

public class VendorBean {
	String vname,password,email,phoneno,city;
	String status;
	public Vendor details=null;
	VendorImpl dao=null;
	public VendorBean() {
		super();
		dao=new VendorImpl();
		
		
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getPassword() {
		return password;
	}
	public Vendor getDetails() {
		return details;
	}
	public void setDetails(Vendor details) {
		this.details = details;
	}
	public List<Vendor> getVend() {
		return vend;
	}
	public void setVend(List<Vendor> vend) {
		this.vend = vend;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public VendorImpl getDao() {
		return dao;
	}
	public void setDao(VendorImpl dao) {
		this.dao = dao;
	}
	
	
	public String RegisterVendor()
	{
		Vendor V=null;
		V=new Vendor(vname, email, password, city, phoneno);
		
		String msg=dao.Register_Vendor(V);
		return msg;
	}
	
	public String AuthenVendorBean()
	{
	
		try {
			System.out.println("inside bean authvndor");
			details=dao.AuthenticateVendor(email, password);
			System.out.println("details"+details.getName());
		}catch(RuntimeException e)
		{
			System.out.println("err in login"+e);
			status="Invalid Login please try again!!!";
			return "login";
			
		}
		status="successful login";
		return "Vdetails";
	}
	List<Vendor> vend=null;
	public List<Vendor> getVendorDetails()
	{
		try {System.out.println("inside list vndors");
		vend=dao.getVendorList();
		for(Vendor v:vend)
		{
		System.out.println("inside dao get result list"+v);
		}

		}
		catch(RuntimeException e)
		{
			System.out.println("err in get details bean"+e);
			
		}
		return vend;
		
	}
	
	public String UpdateVendor()
	{
		String msg="not updated";
		try {
			msg=dao.UpdateVendor(email, city, phoneno);
		}
		catch(RuntimeException e)
		{
			System.out.println("err in update"+e);
			return msg;
		}
		return msg;
		
	}
	
public String Delete_vendor()
{String msg = null;
try {
	msg=dao.Delete(email, password);
	
}
catch(RuntimeException e)
{
	System.out.println("err"+e);
	
	
}
return msg;
}
}
