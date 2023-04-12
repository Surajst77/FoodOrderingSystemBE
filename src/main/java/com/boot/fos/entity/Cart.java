package com.boot.fos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
   @Id
   private int foodId;
	 
   private String foodName;
   
   private String foodDesc;
   
   private int foodPrice;
   
   private String foodType;
   
   private String foodImage;
   
   @JsonBackReference(value="customers")
   @ManyToOne
   private Customer customers;

	@Override
	public String toString() {
		return "Cart [foodId=" + foodId + ", foodName=" + foodName + ", foodDesc=" + foodDesc + ", foodPrice=" + foodPrice
				+ ", foodType=" + foodType + ", foodImage=" + foodImage + "]";
	}

	

	
	
}
