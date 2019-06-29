package Dao;

import java.util.List;

import POJO.Vendor;

public interface IVendor {

	String Register_Vendor(Vendor V);
	List<Vendor> getVendorList();
    String UpdateVendor(String email,String city,String phoneno);
    String Delete(String email,String password);
    Vendor AuthenticateVendor(String email,String password);
  
}
