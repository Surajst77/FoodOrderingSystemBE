package com.boot.fos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Admin {
	
	@Id
	private String adminEmail;
	
	@Column(length = 12,nullable = false)
	@NotBlank(message = "Password cannot be Empty")
	@Size(min = 6,max=12,message = "Password should contain at least 6 characters or digits")
	private String adminPass;
	
}
