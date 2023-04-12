package com.boot.fos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.fos.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
