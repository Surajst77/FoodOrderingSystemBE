package com.boot.fos.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.fos.entity.Cart;
import com.boot.fos.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addtocart/{id}")
	public Cart addToCart(@RequestBody Cart cart, @PathVariable String id) {
		
		return cartService.addToCart(cart, id);
	}
	
}
