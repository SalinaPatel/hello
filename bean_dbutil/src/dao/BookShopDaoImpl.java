package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Book;
import pojos.Customer;
//import all static members of DBUtils class
import static utils.DBUtils.*;

public class BookShopDaoImpl implements IBookShopDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4, pst5;

	// constr
	public BookShopDaoImpl() throws Exception {
		// get cn from DBUtils
		cn = fetchConnection();
		// pst1
		pst1 = cn.prepareStatement("select * from my_customers where email=? and password=?");
		// pst2 --customer reg --insert query
		pst2 = cn.prepareStatement("insert into my_customers values(default,?,?,?,?,?,?)");
		pst3 = cn.prepareStatement("select distinct category from dac_books");
		pst4 = cn.prepareStatement("select * from dac_books where category=?");
		pst5 = cn.prepareStatement("select * from dac_books where id=?");
		System.out.println("dao created...");
	}

	// clean up
	public void cleanUp() throws Exception {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (pst5 != null)
			pst5.close();

		if (cn != null)
			cn.close();
		System.out.println("dao cleaned up...");
	}

	@Override
	public Customer validateCustomer(String email, String pwd) throws Exception {
		System.out.println("dao : validate customer");
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, pwd);
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Customer(rst.getInt(1), rst.getDouble(2), email,rst.getString(4),  pwd, rst.getDate(6),
						rst.getString(7));
		}
		return null;
	}

	@Override
	public String registerCustomer(Customer c) throws Exception {
		// set IN params
		// dep amt
		pst2.setDouble(1, c.getRegAmount());
		// em name pass
		pst2.setString(2, c.getEmail());
		pst2.setString(3, c.getName());
		pst2.setString(4, c.getPassword());
		// dt role
		pst2.setDate(5, c.getRegDate());
		pst2.setString(6, c.getRole());
		// exec update
		int updateCnt = pst2.executeUpdate();
		if (updateCnt == 1)
			return "Customer registered successfully...";
		return "Customer registration failed!!!!";
	}

	@Override
	public List<String> getAllCategories() throws Exception {
		// creat empty List
		ArrayList<String> cats = new ArrayList<>();
		try (ResultSet rst = pst3.executeQuery()) {
			while (rst.next())
				cats.add(rst.getString(1));
		}
		System.out.println("dao reted categories " + cats);
		return cats;
	}

	@Override
	public List<Book> getBooksByCategory(String catName) throws Exception {
		// set IN param
		pst4.setString(1, catName);
		// empty list of books
		ArrayList<Book> bks = new ArrayList<>();
		try (ResultSet rst = pst4.executeQuery()) {
			while (rst.next())
				bks.add(new Book(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getDouble(5)));
		}
		System.out.println("dao reted : " + bks);
		return bks;
	}

	@Override
	public Book getBookDetails(int bookId) throws Exception {
		// set IN param
		pst5.setInt(1, bookId);
		try (ResultSet rst = pst5.executeQuery()) {
			if (rst.next())
				return new Book(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDouble(5));
		}
		return null;
	}

}
