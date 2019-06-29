package dao;

import java.util.List;

import pojos.Book;
import pojos.Customer;

public interface IBookShopDao {
	//user validation
	Customer validateCustomer(String email,String pwd) throws Exception;
    //user registration
	String registerCustomer(Customer c) throws Exception;
	//get category list
	List<String> getAllCategories() throws Exception;
	//get books by selected category
	List<Book> getBooksByCategory(String catName) throws Exception;
    //get book details
	Book getBookDetails(int bookId) throws Exception;
}
