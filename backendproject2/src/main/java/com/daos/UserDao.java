package com.daos;

import java.util.List;

import com.models.User;

public interface UserDao {
	  public boolean registerUser(User userObj);
	    public boolean checkLogin(User userObj);
	    public boolean updateOnlineStatus(String status,String email);
	    public User getUser(String email);
	    public List<User> getUsers();
	    public boolean deleteUser(User userObj);
	    public boolean updateUser(User userObj);
}
