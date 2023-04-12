package com.boot.fos.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Customer {
	
	@Id
	@Column(length=50,nullable=false)
	@NotBlank(message="Id cannot be empty")
	private String email;
	
	@Column(length = 30,nullable = false)
	@NotBlank(message = "Customer Name cannot be Empty")
	private String custFirstName;
	
	@Column(length = 300, nullable=false)
	@NotBlank(message ="Last Name cannot be empty")
	private String custLastName;
	
	@Column(length=66,nullable = false)
	@NotBlank(message = "Customer Password cannot be Empty")
	@Size(min = 6, message = "Password Should contain at least 6 characters Maximum 12")
	private String password;
	
	@Transient
	private String message;
	
	@Transient
	private boolean status;
	
	@JsonProperty(access = Access.AUTO)
	@OneToMany( cascade=CascadeType.MERGE,mappedBy="customers")
	private List<Cart> carts;// = new ArrayList<>();
	
	public Customer(String message, boolean status){
		this.message = message;
		this.status = status;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String email, @NotBlank(message = "Customer Name cannot be Empty") String custFirstName,
			@NotBlank(message = "Last Name cannot be empty") String custLastName,
			@NotBlank(message = "Customer Password cannot be Empty") @Size(min = 6, message = "Password Should contain at least 6 characters Maximum 12") String password) {
		super();
		this.email = email;
		this.custFirstName = custFirstName;
		this.custLastName = custLastName;
		this.password = password;
	}
	
	public void addToCart(Cart cart) {
		if(getCarts()==null) {
			this.carts = new ArrayList<Cart>();	
		}
		getCarts().add(cart);
		cart.setCustomers(this);
	}
	
	public void removeFromCart(Cart cart) {
		if (getCarts()!=null) {
			getCarts().remove(cart);
		}
	}
	
	@Override
	public String toString() {
		return "Customer [email=" + email + ", custFirstName=" + custFirstName + ", custLastName=" + custLastName
				+ ", password=" + password + "]";
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {	
//		List<Authority> autho = new ArrayList<>();
//		this.carts.forEach(cartRole ->{
//			autho.add(new Authority(cartRole.getFoodName()));
//			});
//		return null;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true ;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	
}
