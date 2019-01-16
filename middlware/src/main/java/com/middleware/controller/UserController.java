package com.middleware.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daos.UserDao;
import com.models.User;

@Controller
public class UserController { 

	@Autowired
	UserDao userDAO;
	

	@GetMapping(value="/demo")
	public ResponseEntity<String> demoPurpose(){
		return new ResponseEntity<String>("Demo Data",HttpStatus.OK);
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<String> registerUser(@RequestBody User user){
		user.setOnlineStatus("Offline");
		user.setRole("Role_User");
		
		if(userDAO.registerUser(user)){
			return new ResponseEntity<String>("User Registered Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error in Registering User . Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping(value="/login")
	public ResponseEntity<User> checkLogin(@RequestBody User userDetails,HttpSession session){
		
		User user=null;
		if(userDAO.checkLogin(userDetails)){
			
			System.out.println("I m valid user"+userDetails.getEmail());
			user=(User)userDAO.getUser(userDetails.getEmail());
			userDAO.updateOnlineStatus("Online", user.getEmail());
			session.setAttribute("userObj",user);
			System.out.println("Attribute Added in Session");
			return new ResponseEntity<User>(user,HttpStatus.OK);
		 	
		}
		else {
			System.out.println("Invalid user");
			return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="/updateOnlineStatus/{status}/{email:.+}")
	public ResponseEntity<String> updateOnlineStatus(@PathVariable String status,@PathVariable String email){
		
		if(userDAO.updateOnlineStatus(status, email)){
			return new ResponseEntity<String>("Status Updated Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Not able to update status succesfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value="getUser/{email:.+}")
	public ResponseEntity<User> getUserByLoginName(@PathVariable String email){
		
		System.out.println("In get user function"+email);
		User user=userDAO.getUser(email);
		
		System.out.println(user.getEmail());
		if(user!=null){
			
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<User>(user,HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestBody User user){
		User userObj=userDAO.getUser(user.getEmail());
		if(userDAO.deleteUser(userObj)){
			return new ResponseEntity<String>("User deleted succesfully...",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Problem in deleting User...",HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping(value="/getListOfUsers")
	public ResponseEntity<List<User>> getUsersList(){
		List<User> list=userDAO.getUsers();
		if(list.size()!=0){
			return new ResponseEntity<List<User>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<User>>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="getUserData")
	public ResponseEntity<?> getUser(HttpSession session){
		User user=(User)session.getAttribute("userObj");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		
		if(userDAO.updateUser(user)){
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			Error errorObj=new Error("Problem in Updating User");
			return new ResponseEntity<Error>(errorObj,HttpStatus.NOT_FOUND);
		}
	}
	
}
	/*@PostMapping(value="signUp")
	public ResponseEntity<String> addUser(@RequestBody User userObj){
		userObj.setRole("Role_User");
		userObj.setOnlineStatus("Offline");
		
		boolean result=userDAO.registerUser(userObj);
		if(result){
			return new ResponseEntity<String>("User Registered Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Problem in registering. Try Again",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping("getUser/{emailAddr:.+}")
	public ResponseEntity<User> getUser(@PathVariable("emailAddr")String emailAddress){
		
		System.out.println(" emailAddress : "+emailAddress);
		User user=userDAO.getUser(emailAddress);
		System.out.println(user.getEmail()+" "+user.getFirstName());
		if(user==null){
		return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
}
		else {
		return new ResponseEntity<User>(user,HttpStatus.OK);
		}
	}
	
	
	
	

	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody User user){
		
		if(userDAO.updateUser(user)){
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			Error errorObj=new Error("Problem in Updating User");
			return new ResponseEntity<Error>(errorObj,HttpStatus.NOT_FOUND);
		}
	}
		
		
	
		
@GetMapping(value="/getListOfUsers")
public ResponseEntity<List<User>> getUsersList(){
	List<User> list=userDAO.getUsers();
	if(list.size()!=0){
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<List<User>>(list,HttpStatus.NOT_FOUND);
	}
}


@PostMapping("/deleteUser")
public ResponseEntity<String> deleteUser(@RequestBody User user){
	User userObj=userDAO.getUser(user.getEmail());
	if(userDAO.deleteUser(userObj)){
		return new ResponseEntity<String>("User deleted succesfully...",HttpStatus.OK);
	}
	else {
		return new ResponseEntity<String>("Problem in deleting User...",HttpStatus.NOT_FOUND);
	}
}


@GetMapping(value="/updateOnlineStatus/{status}/{email:.+}")
public ResponseEntity<String> updateOnlineStatus(@PathVariable String status,@PathVariable String email){
	
	if(userDAO.updateOnlineStatus(status, email)){
		return new ResponseEntity<String>("Status Updated Succesfully",HttpStatus.OK);
	}
	else {
		return new ResponseEntity<String>("Not able to update status succesfully",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

@PostMapping(value="/register")
public ResponseEntity<String> registerUser(@RequestBody User user){
    user.setOnlineStatus("Offline");
    user.setRole("Role_User");
     
    if(userDAO.registerUser(user)){
        return new ResponseEntity<String>("User Registered Succesfully",HttpStatus.OK);
    }
    else {
        return new ResponseEntity<String>("Error in Registering User . Please try again",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

 
@PostMapping(value="/login")
public ResponseEntity<User> checkLogin(@RequestBody User userDetails,HttpSession session){
     
	System.out.println("I m here");
    User user=null;
    if(userDAO.checkLogin(userDetails)){
         
        System.out.println("I m valid user"+userDetails.getEmail());
        user=(User)userDAO.getUser(userDetails.getEmail());
        userDAO.updateOnlineStatus("Online", user.getEmail());
        session.setAttribute("userObj",user);
        System.out.println("Attribute Added in Session");
        return new ResponseEntity<User>(user,HttpStatus.OK);
         
    }
    else {
        System.out.println("Invalid user");
        return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@GetMapping(value="getUserData")
public ResponseEntity<?> getUser(HttpSession session){
	
	User user=(User)session.getAttribute("userObj");
	return new ResponseEntity<User>(user,HttpStatus.OK);
}

@PostMapping("/updateUser")
public ResponseEntity<?> updateUser1(@RequestBody User user){
	
	if(userDAO.updateUser(user)){
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<String>("Problem in updating User...",HttpStatus.NOT_FOUND);
	}
} 
}*/