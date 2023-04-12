package com.boot.fos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.boot.fos.entity.Customer;

@EnableJpaRepositories
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	Optional<Customer> findByEmailAndPassword(String custEmail, String custPassword);
	
	Customer findByEmail( String custEmail);

	

}