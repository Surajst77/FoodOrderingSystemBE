package com.boot.fos.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
public class Food {
	
//	private static final long serialVersionUID = 214978706977847741L;
	
	@Id
	@NotNull(message = "Food Id cannot be Empty")
	private String foodId;
	
	@Column(length = 50,nullable = false)
	@NotBlank(message = "Food Name cannot be Empty")
	private String foodName;
	
	@Column(length = 200)
	private String foodDesc;
	
	@Column(length = 10,nullable = false)
	@NotNull(message = "Food Price cannot be Empty")
	private int foodPrice;
	
	@Column(length = 7,nullable = false)
	@NotBlank(message = "Food Type cannot be Empty")
	@Size(min = 3, max = 7,message = "Food Type Can be of Veg or Non Veg")
	private String foodType;
	
	@Column(nullable=false)
	@NotNull(message = "Food Image cannot be Empty")
	private String foodImage;
	
}
