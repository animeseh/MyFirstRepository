package com.niit.controllers;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.daos.CategoryDao;
import com.onlineshop.daos.ProductDao;
import com.onlineshop.daos.SupplierDao;
import com.onlineshop.models.Category;
import com.onlineshop.models.Supplier;


@Controller
public class CategoryController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/admin/getCategoryForm",method=RequestMethod.GET)
	public ModelAndView getAddCategoryForm(){
		System.out.println("I m in get Add Category Form");
		ModelAndView mv= new ModelAndView("CategoryForm");
		mv.addObject("catobj",new Category());
		mv.addObject("myaction","addCategoryProcess");
		return mv;
	}
	
	
	@RequestMapping(value="/admin/addCategoryProcess",method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("catobj")Category catObj){
		ModelAndView mv=new ModelAndView("ViewCategories");
		if(catObj.getCategoryId()==0){
			mv.addObject("msgToDisplay","Category Added");
		
		}
		else{
			
			mv.addObject("msgToDisplay", "Category Updated");
		}
		categoryDao.addCategory(catObj);
		mv.addObject("categoryList",categoryDao.getAllCategories());
		
		
		
		return mv;
	}
	

	
	@RequestMapping(value="/admin/ViewCategories",method=RequestMethod.GET)
	public ModelAndView fetchCategories(){
		ModelAndView mv=new ModelAndView("ViewCategories");
		List<Category> catList=categoryDao.getAllCategories();
		
		System.out.println(catList);
		
		mv.addObject("categoryList",catList);
		
		return mv;
	}
	
	@RequestMapping(value="/admin/deleteCategory/{cId}",method=RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("cId")int categoryId){
		
		Category obj=categoryDao.getCategoryById(categoryId);
		categoryDao.deleteCategory(obj);
		
		ModelAndView mv= new ModelAndView("ViewCategories");
		mv.addObject("msgToDisplay","Category Deleted Succesfully");
		mv.addObject("categoryList",categoryDao.getAllCategories());
		return mv;
	}
 	
	@RequestMapping(value="/admin/updateCategory/{cId}",method=RequestMethod.GET)
	public ModelAndView updateCategory(@PathVariable("cId")int categoryId){
		
		Category catObj=categoryDao.getCategoryById(categoryId);
		
		
		ModelAndView mv= new ModelAndView("CategoryForm");
		
		/*sObj is the name we have written in the model attribute of CategoryForm.jsp*/
		mv.addObject("catobj", catObj);
		mv.addObject("heading","Update CategoryForm");
		mv.addObject("button","Update Category ");
		return mv;
	}
	@Autowired
	ProductDao productDaoObj;
	@RequestMapping(value="/viewAllProducts/{cId}",method=RequestMethod.GET)
	 public ModelAndView fetchProductsForCategory(@PathVariable("cId")int categoryId){
		ModelAndView mv =new 	ModelAndView ("ViewProducts");
		mv.addObject("productlist",productDaoObj.getAllProductsByCategory(categoryId));
		return mv;
		
		
	}


}


