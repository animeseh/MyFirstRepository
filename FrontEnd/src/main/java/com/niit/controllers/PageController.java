package com.niit.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import com.onlineshop.daos.CategoryDao;
import com.onlineshop.daos.ProductDao;
import com.onlineshop.daos.UserDao;
import com.onlineshop.models.Category;
import com.onlineshop.models.User;

@Controller
public class PageController {
	 @Autowired
	 CategoryDao categoryDao;
	
	 @Autowired
	 UserDao userdao1;
	 
	 @Autowired
	 HttpServletRequest request;
	 
	 @Autowired
	 HttpSession session;
	 
	 @RequestMapping(value={"/","/home"},method=RequestMethod.GET)
		public ModelAndView getHomePage(){
			System.out.println("I m here in getHome Page method");
			Principal principal = request.getUserPrincipal();
			
			
			System.out.println("PRINCIPAL IS  NOT ACTIVE " + principal);
			
			if(principal!=null){
				String userEmail = principal.getName();
				System.out.println("PRINCIPAL IS ACTIVE " + userEmail);
				User user=userdao1.getUser(userEmail);
				System.out.println("Object of User = "+user);
				session.setAttribute("username", user.getName());
				session.setAttribute("useremail", user.getEmail());
			
			}

			session.setAttribute("categoryList", categoryDao.getAllCategories());
			ModelAndView mv=new ModelAndView("HomePage");
			
			return mv;

		}


	    
	     
	    @RequestMapping(value="/admin/getProductPage",method=RequestMethod.GET)
	    public String getProductOptionsPage(){
	        return "Product";
	    }
	     
	    @RequestMapping(value="/admin//getCategoryPage",method=RequestMethod.GET)
	    public String getCategoryOptionsPage(){
	        return "Category";
	    }
	     
	    @RequestMapping(value="/admin//getSupplierPage",method=RequestMethod.GET)
	    public String getSupplierOptionsPage(){
	        return "Supplier";
	    }
	
        @RequestMapping(value="/getSignUpForm",method=RequestMethod.GET)
        public ModelAndView getSignUp(){
        ModelAndView mv=new ModelAndView("SignUpForm");
        mv.addObject("userObj",new User());
        return mv;
        }

        @Autowired
        UserDao userdao;

        @RequestMapping(value="/registerUser",method=RequestMethod.POST)
        public ModelAndView registerUser(@ModelAttribute("userObj")User user){
	
        	ModelAndView mv=new ModelAndView("SignUpForm");
        	user.setRole("USER");
        	userdao.registerUser(user);
        	return mv;
}			

            @RequestMapping(value="/login",method=RequestMethod.GET)
	        public ModelAndView getLoginForm(@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout){
		    System.out.println("I m in getLogin Form method");
		    ModelAndView mv=new ModelAndView("login");
		    if(error!=null){
			mv.addObject("message","Username or password is incorrect");
		}
		if(logout!=null){
			mv.addObject("message","User has succesfully logged out!!");
		}
		
		return mv;
	}
        
        @RequestMapping(value="/access-denied")
    	public ModelAndView accessDenied() {
    		ModelAndView mv = new ModelAndView("Error");		
    		mv.addObject("errorMsg", "You are not authorized to access this page");		
    		return mv;
    	}
       
        


@RequestMapping(value="dologout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
			
		}
		return "redirect:/login?logout";
	}
}
        