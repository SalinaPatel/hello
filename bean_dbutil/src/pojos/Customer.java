package pojos;

import java.sql.Date;

public class Customer {
	private int id;
	private double regAmount;
	private String email,name,password;
	private Date regDate;
	private String role;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, double regAmount, String email, String name, String password, Date regDate, String role) {
		super();
		this.id = id;
		this.regAmount = regAmount;
		this.email = email;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
		this.role = role;
	}
	public Customer(double regAmount, String email, String name, String password, Date regDate, String role) {
		super();
		this.regAmount = regAmount;
		this.email = email;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", regAmount=" + regAmount + ", email=" + email + ", name=" + name + ", password="
				+ password + ", regDate=" + regDate + ", role=" + role + "]";
	}
	
	
}
