package com.onlineshop.ProjectBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.daos.SupplierDao;
import com.onlineshop.daos.UserDao;
import com.onlineshop.models.Supplier;
import com.onlineshop.models.User;

public class UserTestCase {


	static UserDao userObj;
	
	@BeforeClass /*as soon as this class will get instialized this class will be called bzs of this annotattion*/
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.onlineshop");
		app.refresh();
		userObj=app.getBean("userDao",UserDao.class);
	}
	
	@Test /* To run only the selected test, position the cursor on the test method name and use the shortcut. */
	@Ignore
	public void addUserTest(){
		User user=new User();
		user.setEmail("tom@gmail.com");
		user.setName("Tom");
		user.setPassword("user123");
		user.setRole("USER");
		user.setPhone("8574857485");
		
		boolean r=userObj.registerUser(user);
		
		/*This test will fail if value of r is false . */
		assertTrue("Problem in Adding User",r);
	}
	
	@Test
	@Ignore
	public void deleteUser(){
		/*User user=userObj.getUserById(34);
		boolean r=userObj.deleteUser(user);
		
	*/	//assertTrue("Problem in deleting User",r);
		
		
		
	}
	
	
			

		
		

				
	}
	
	
	

	
	

	