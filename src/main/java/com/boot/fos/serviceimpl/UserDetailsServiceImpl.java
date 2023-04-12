package com.boot.fos.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.fos.entity.Customer;
import com.boot.fos.exception.ResourceNotFound;
import com.boot.fos.repository.CustomerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private CustomerRepository custRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		Customer cust = this.custRepo.findByEmail(username);
//		if(cust == null)
//		{
//			System.out.println("User Not found");
//			throw new ResourceNotFound("User", "Not Found", 0);
//		}
//		return cust.getCustFirstName();
//	}

}
