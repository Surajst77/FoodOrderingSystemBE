package com.boot.fos.serviceimpl;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.fos.entity.Cart;
import com.boot.fos.entity.Customer;
import com.boot.fos.repository.CartRepository;
import com.boot.fos.repository.CustomerRepository;
import com.boot.fos.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	String emails;
	
	@Override
	public Cart addToCart(Cart cart, String em) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql:///fos", "root","Suraj_st7?");
			
			Statement stmt = con.createStatement();
					
			ResultSet res  = stmt.executeQuery("select email from Customer where email='"+em+"'");

			while(res.next()) { 
			emails = res.getString("email");
			System.out.println("email: "+emails);
			}

			}
			catch(ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		
		Customer cst = new Customer();
		cst = custRepo.findByEmail(emails);
		System.out.println("This is my cst: "+cst);
		cst.addToCart(cart);
		return cartRepo.save(cart);
	}
	
	
	
}
