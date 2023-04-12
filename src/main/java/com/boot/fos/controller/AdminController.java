package com.boot.fos.controller;

import java.util.List;
import java.util.Random;

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

import com.boot.fos.entity.Admin;
import com.boot.fos.entity.Cart;
import com.boot.fos.exception.LoginMessage;
import com.boot.fos.service.AdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/add")
	public Cart addFoods(@RequestBody Cart cart){
		return adminService.addFood(cart);
				
	}
	
	
	@PostMapping("/login")
	public LoginMessage adminLogin(@RequestBody Admin admin) {
		System.out.println("admin Email: "+admin.getAdminEmail());
		System.out.println("admin Password: "+admin.getAdminPass());
		return adminService.adminLogin(admin);
	}
//	@PostMapping("/addit")
//	public ResponseEntity<LoginMessage> saveFood(@RequestParam("file") MultipartFile file, @RequestParam("user") String admin) throws JsonProcessingException,JsonMappingException,JsonParseException, IOException{
//		
//		Food food = new ObjectMapper().readValue(admin,Food.class);
//		food.setFoodImage(file.getBytes());
//		food.setFileName(file.getOriginalFilename());
//		Food food2 = adminService.saveFood(food);
//		if(food2 != null)
//		{			
//			return new ResponseEntity<LoginMessage>(new LoginMessage("Added Successfully",true),HttpStatus.OK);
//		}
//		else 
//			return new ResponseEntity<LoginMessage>(new LoginMessage("Failed ",false),HttpStatus.BAD_REQUEST);
//	}
	
//	@PostMapping
//	public void adminLogin
	
	@GetMapping("/")
	public List<Cart> getAllItems()
	{
		return adminService.getAllFoodItems();
	}
	
	
	
	@GetMapping("/{id}")
	public Cart getItemById(@PathVariable("id") int id) {
		
		return adminService.getFoodById(id); 
	}
	
	@DeleteMapping("/{id}")
	public void deleteFoodItems(@PathVariable("id") int id) {
		
		adminService.deleteFoodById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateItemById(@PathVariable("id") int id,@RequestBody Cart food) {
		
//		Food updateFood = adminService.updateFoodById(food, id);
		return new ResponseEntity<Cart>( adminService.updateFoodById(food, id),HttpStatus.OK);
	}
}
