package com.boot.fos.service;

import java.util.List;

import com.boot.fos.dto.LoginDTO;
import com.boot.fos.entity.Cart;
import com.boot.fos.entity.Customer;
import com.boot.fos.entity.Food;
import com.boot.fos.exception.LoginMessage;

public interface CustomerService {
	
	public Customer addCust(Customer cust) ;
	
	public LoginMessage loginEmployee(LoginDTO login);
	
	public Customer getCust(String id);
	
	public List<Customer> getAllCusts();
	
	public Customer updateCustomer(Customer cust,String id);
	
	public void deleteCustomer(String id);

	public Cart addToCart(Cart cart, String em);
	
	public List<Cart> getCartById(String id);
	
	public void removeFromCart(int foodId, String uId);

	
}
