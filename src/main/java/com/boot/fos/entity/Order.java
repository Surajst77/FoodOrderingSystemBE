package com.boot.fos.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Entity
//@Data
@ToString
@Table(name="order_table")
public class Order {
	@Id
	private long orderId;
	
	@Column(length = 30,nullable = false)
	@NotBlank(message = "Student Name cannot be Empty")
	@Size(min = 5, max = 10,message = "Name should be minimun 5 characters and maximun 10 charcters")
	private String orderName;
	
//	@ManyToMany(mappedBy="custOrderId")
//	private List<Customer> orderCustomerId = new ArrayList<>();
	
	private int quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime = new Date(System.currentTimeMillis());

	

	
}
