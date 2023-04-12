package com.boot.fos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.fos.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{

}
