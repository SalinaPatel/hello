package com.app.dao;
import java.util.List;

import com.app.pojos.*;



public interface IVendor {
	public Vendor validate(String email,String password); 
	public String AddVendor(Vendor v);
	public List<Vendor> listVendor();
	public void update(int id,String city);
	public void delete(int id);

}
