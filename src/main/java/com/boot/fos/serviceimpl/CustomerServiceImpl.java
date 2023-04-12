package com.boot.fos.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.fos.dto.LoginDTO;
import com.boot.fos.entity.Cart;
import com.boot.fos.entity.Customer;
import com.boot.fos.exception.LoginMessage;
import com.boot.fos.exception.ResourceNotFound;
import com.boot.fos.repository.CartRepository;
import com.boot.fos.repository.CustomerRepository;
import com.boot.fos.repository.FoodRepository;
import com.boot.fos.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository custRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private FoodRepository foodRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public Customer addCust(Customer cust) {

		Customer cus = new Customer(
				 cust.getEmail(),
				 cust.getCustFirstName(),
				 cust.getCustLastName(),
				 this.passwordEncoder.encode(cust.getPassword())
				
				);
		if(!custRepo.existsById(cus.getEmail())) {
		custRepo.save(cus);
		cus.setStatus(true);
		}else {
//			cus = null;
			return new Customer("You are already Registered with us please go to login page", false);
		}
			
		return cus;
		
	}

	@Override
	public LoginMessage loginEmployee(LoginDTO login) {
		String msg = "";
		Customer cust = custRepo.findByEmail(login.getEmail());
		if(cust != null)
		{
			String password = login.getPassword();
			String encodePassword = cust.getPassword();
			Boolean isPwdRyt = passwordEncoder.matches(password, encodePassword);
			if(isPwdRyt)
			{
				Optional<Customer> cust2 = custRepo.findByEmailAndPassword(login.getEmail(), encodePassword);
				if(cust2.isPresent()) {
					return new LoginMessage("Login Success", true);
				}
				else 
					return new LoginMessage("Login Failed", false);
			}
			else {
				return new LoginMessage("Password didn't Match", false);
			}	
		}
		else 
			return new LoginMessage("Email Not Exists", false);
	}
	
	@Override
	public Customer getCust(String id) {
		
		return null;//custRepo.findById(id).orElseThrow(()-> new ResourceNotFound("Customer", "id", id));
	}
	
	@Override
	public List<Customer> getAllCusts()
	{
		return custRepo.findAll();
	}
	
	@Override
	public Customer updateCustomer(Customer cust,String id) {
		
		 Customer customer = custRepo.findById(id).orElseThrow(()-> new ResourceNotFound("Customer", "id", id));
		 customer.setEmail(cust.getEmail());
		 customer.setCustFirstName(cust.getCustFirstName());
		 customer.setCustLastName(cust.getCustLastName());
		 customer.setPassword(cust.getPassword());
//		 
		 custRepo.save(customer);
		 return null;//customer;
	}
	
	@Override
	public void deleteCustomer(String id)
	{	
		custRepo.findById(id).orElseThrow(()->new ResourceNotFound("Id Not Found ","with this ",id));
		custRepo.deleteById(id);
	}


	
	String emails;
	
	@Override
	public Cart addToCart(Cart cart, String em) {
		Customer cst =  new Customer();
		
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
	
		cst = custRepo.findByEmail(emails);
		System.out.println("This is my cst: "+cst);
		cst.addToCart(cart);
		return cartRepo.save(cart);
	}

	@Override
	public List<Cart> getCartById(String id) {
		Customer cst =  new Customer();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql:///fos", "root","Suraj_st7?");
			
			Statement stmt = con.createStatement();
					
			ResultSet res  = stmt.executeQuery("select email from Customer where email='"+id+"'");

			while(res.next()) { 
			emails = res.getString("email");
			System.out.println("email: "+emails);
			}

			}
			catch(ClassNotFoundException | SQLException e) {

				e.printStackTrace();
			}
		cst = custRepo.findByEmail(emails);
		System.out.println("Remove from cart email: "+cst);
		return cst.getCarts();
	}

	@Override
	public void removeFromCart(int foodId, String uId) {		
		Customer cst =  new Customer();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql:///fos", "root","Suraj_st7?");
		
		Statement stmt = con.createStatement();
				
		ResultSet res  = stmt.executeQuery("select email from Customer where email='"+uId+"'");

		while(res.next()) { 
		emails = res.getString("email");
		System.out.println("email: "+emails);
		}

		}
		catch(ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		Customer user = custRepo.findByEmail(emails);
		Cart cart = cartRepo.findById(foodId).orElse(null);
		user.removeFromCart(cart);
		cartRepo.delete(cart);
		
	}

	
}
