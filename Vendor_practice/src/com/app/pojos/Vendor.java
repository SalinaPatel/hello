package com.app.pojos;








import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="vendor")
public class Vendor {
	
	private Integer id;
	private String name;
	private String email;
	private String password,role ,city,phoneno;
	private Date reg_date;
	private double amt;
	public Vendor() {
	System.out.println("in Vendor constructor");
	}
	public Vendor(String name, String email, String password, String role,
			String city, String phoneno, Date reg_date,
			double amt) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.city = city;
		this.phoneno = phoneno;
		this.reg_date = reg_date;
		this.amt = amt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name",length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=20)
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20)
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	
	
	
	
	

}
