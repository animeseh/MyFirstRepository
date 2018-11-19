package com.onlineshop.daos;

import java.util.List;

import com.onlineshop.models.Address;
import com.onlineshop.models.User;

public interface UserDao {

	public boolean registerUser(User user);
	public User validateUser(String email,String password);
	public boolean addAddress(Address address);
	 public User getUser(String email);
	public Address getAddress(int addressId);
	public boolean deleteAddress(Address address);
	public boolean updateAddress(Address address);
	public List<Address> getAllAddressForUser(String email);
	
	
}
