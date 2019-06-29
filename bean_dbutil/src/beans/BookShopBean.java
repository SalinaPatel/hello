package beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import dao.BookShopDaoImpl;
import pojos.Book;
import pojos.Customer;

public class BookShopBean {
	// D.M
	private String email, password, name, role, regDate;
	private String category;
	private double regAmount;
	//selected book ids
	private int[] bkId;

	// DAO
	private BookShopDaoImpl dao;
	// result --customer details from db
	private Customer details;
	// status mesg
	private String status;
	//cart
	private List<Integer> cart;
	//total cart value
	private double total;

	// constr
	public BookShopBean() throws Exception {
		System.out.println("in jb constr");
		// create DAO instance
		dao = new BookShopDaoImpl();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
		System.out.println("in set email");
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BookShopDaoImpl getDao() {
		return dao;
	}

	public void setDao(BookShopDaoImpl dao) {
		this.dao = dao;
	}

	public Customer getDetails() {
		return details;
	}

	public void setDetails(Customer details) {
		this.details = details;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	public String getStatus() {
		return status;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	public void setBkId(int[] bkId) {
		this.bkId = bkId;
	}
	

	public List<Integer> getCart() {
		return cart;
	}
	

	public double getTotal() {
		return total;
	}

	// B.L --public --for customer validation
	public String authenticateCustomer() throws Exception {
		System.out.println("in jb : validate");
		details = dao.validateCustomer(email, password);
		if (details == null) {
			status = "Invalid login , Pls retry....";
			return "login";
		}
		//successful login
		//create an empty cart -- it will get auto stored unbder session scope
		cart=new ArrayList<>();
		status = "Successful Login!!!";
		return "category";
	}

	// B.L --public --for customer registration
	public String registerCustomer() throws Exception {
		System.out.println("jb : reg cust");
		// create customer obj --holding clnt's info
		Customer c = new Customer(regAmount, name, email, password, Date.valueOf(regDate), role);
		// invoke dao's method for persistence
		return dao.registerCustomer(c);
	}
	//B.L method for sending list of categories to JSP
	public List<String> getCategories() throws Exception{
		System.out.println("jb : get cats");
		return dao.getAllCategories();
	}
	//B.L method for getting sbook bu selected category
	public List<Book> fetchSelectedBooks() throws Exception{
		System.out.println("in jb : fetch bks "+category);
		return dao.getBooksByCategory(category);
	}
	//B.L method to populate cart
	public String populateCart() throws Exception
	{
		//copy selected book ids in cart
		for(int id : bkId)
			cart.add(id); //auto boxing
		System.out.println("in jb : cart "+cart);
		return "category";
	}
	//B.L method for getting cart details  & compute total bill
	public List<Book> getCartContents() throws Exception{
		System.out.println("jb : get cart conts");
		List<Book> bks=new ArrayList<>();
		total =0;
		for(int id : cart) //auto un boxing Integer--->int
		{
			Book b=dao.getBookDetails(id);
			bks.add(b);
			total += b.getPrice();
		}
		 System.out.println("jb reted "+bks);
		return bks;
			
	}
	
	

}
