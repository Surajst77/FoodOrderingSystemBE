package com.boot.fos.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.fos.dto.LoginDTO;
import com.boot.fos.entity.Cart;
import com.boot.fos.entity.Customer;
import com.boot.fos.exception.LoginMessage;
import com.boot.fos.service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping("/cust")
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
		
	@PostMapping
	public ResponseEntity<Customer> saveCust(@RequestBody Customer cust) {
		
	return new ResponseEntity<Customer>(custService.addCust(cust), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginMessage>loginEmployee(@RequestBody LoginDTO login){
		
		return ResponseEntity.ok(custService.loginEmployee(login));
//		return new ResponseEntity<LoginMessage>(this.custService.loginEmployee(login), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") String id){
		
		return new ResponseEntity<Customer>(custService.getCust(id),HttpStatus.OK);
	}
	
	@GetMapping("/")	
	public ResponseEntity<List<Customer>> getAllCusts(){
		
		return new ResponseEntity<List<Customer>>(custService.getAllCusts(),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust, @PathVariable("id") String id){
		
		return new ResponseEntity<Customer>(custService.updateCustomer(cust, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable("id") String id) {
		
		custService.deleteCustomer(id);
		return "The Record is deleted";
	}
	
	@PostMapping("/add/{id}")
	public Cart addToCart(@RequestBody Cart cart,@PathVariable("id") String id) {
		
		return custService.addToCart(cart, id);
	}
	
	@GetMapping("/cart/{id}")
	public List<Cart> findCartById(@PathVariable("id") String id) {
		
		return this.custService.getCartById(id);
	}
	
	@DeleteMapping("/removecart/{fid}/{uid}")
	public void removeFromCart(@PathVariable("fid")int fid, @PathVariable("uid")String uid) {
		this.custService.removeFromCart(fid, uid);
	}

}
