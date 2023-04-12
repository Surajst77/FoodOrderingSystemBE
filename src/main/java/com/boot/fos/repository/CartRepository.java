package com.boot.fos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.fos.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{

}
