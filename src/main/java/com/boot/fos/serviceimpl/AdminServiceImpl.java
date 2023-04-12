package com.boot.fos.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.fos.entity.Admin;
import com.boot.fos.entity.Cart;
import com.boot.fos.exception.LoginMessage;
import com.boot.fos.exception.ResourceNotFound;
import com.boot.fos.repository.AdminRepository;
import com.boot.fos.repository.CartRepository;
import com.boot.fos.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private CartRepository cartRepo;

	//	@Override
//	public Food saveFood(Food food) {
//	
//		return foodRepo.save(food);
//	}

	@Override
	public Cart addFood(Cart cart) {
		
		return cartRepo.save(cart);
	}
	
	@Override
	public List<Cart> getAllFoodItems() {
		
		return (List<Cart>) cartRepo.findAll();
	}

	@Override
	public Cart getFoodById(int id) {

		return cartRepo.findById(id).orElseThrow(()->new ResourceNotFound("Employee", "id", id));
	}

	@Override
	public void deleteFoodById(int id) {

		cartRepo.findById(id).orElseThrow(()-> new ResourceNotFound("Employee", "id",id));
		
		cartRepo.deleteById(id);
	}

	@Override
	public Cart updateFoodById(Cart food, int foodId) {
		
		Cart exFood = cartRepo.findById(foodId).orElseThrow(()-> new ResourceNotFound("Employee", "id", foodId));
		exFood.setFoodId(food.getFoodId());
		exFood.setFoodName(food.getFoodName());
		exFood.setFoodDesc(food.getFoodDesc());
		exFood.setFoodType(food.getFoodType());
		exFood.setFoodPrice(food.getFoodPrice());
		cartRepo.save(exFood);
		return exFood;
	}

	@Override
	public LoginMessage adminLogin(Admin admin) {
		final String email="admin@gmail.com";
		final String pass="admin";
		
		if(admin.getAdminEmail().equals(email))
		{
			if(admin.getAdminPass().equals(pass))
			{
				return new LoginMessage("Login Successful",true);
			}
			else {
				return new LoginMessage("Password is incorrect",false);
				}
		}
		else { 
			return new LoginMessage("Invalid Email",false);
			}
	}	
	
}
