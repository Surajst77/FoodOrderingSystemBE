package com.boot.fos.service;

import java.util.List;

import com.boot.fos.entity.Admin;
import com.boot.fos.entity.Cart;
import com.boot.fos.exception.LoginMessage;

public interface AdminService {
	
	// Admin Adds Food Items to the web
//	 public Food saveFood(Food food);
	public LoginMessage adminLogin(Admin admin);
		
	public Cart addFood(Cart cart);
	
	// Admin can get the Food Items all at once 
	public List<Cart> getAllFoodItems();
	
	public Cart getFoodById(int id);
	
	// Admin can delete the food Items 
	public void deleteFoodById(int id);
	
	// Admin can Update the Food Items' Details
	public Cart updateFoodById(Cart food, int foodId);
	
}
