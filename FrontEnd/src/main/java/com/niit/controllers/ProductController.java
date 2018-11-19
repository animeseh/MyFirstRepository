package com.niit.controllers;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.onlineshop.daosimpl.ProductDaoImpl;
import com.onlineshop.models.Category;
import com.onlineshop.models.Product;
import com.onlineshop.models.Supplier;


@Controller
public class ProductController {
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value="/admin/getProductForm",method=RequestMethod.GET)
	public ModelAndView getAddProductForm(){
		System.out.println("I m in get Add Product Form");
		
		ModelAndView mv= new ModelAndView("ProductForm");
		
		List<Category> categoryList=categoryDao.getAllCategories();
		List<Supplier> supplierList=supplierDao.getAllSuppliers();
		
		
		mv.addObject("productObj",new Product());
		mv.addObject("categoryList",categoryList);
		mv.addObject("supplierList",supplierList);
		return mv;
	}
	
	
	@RequestMapping(value="/admin/addProductProcess",method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("productObj")Product product){
		
		System.out.println("Supplier Id : "+product.getSupplierId());
		System.out.println("Category Id : "+product.getCategoryId());
		
		
		String filePathString=session.getServletContext().getRealPath("/");
		System.out.println("filePathString= "+filePathString);
		
		String fileName1=product.getPimage().getOriginalFilename();
		System.out.println("fileName 1 : "+fileName1);
		
		File file=new File(fileName1);
		String fileName2=file.getName();
		
		
		product.setImage(fileName2);
		productDao.addProduct(product);
		
		try{
			byte[] imageBytes=product.getPimage().getBytes();
			FileOutputStream fosm= new FileOutputStream(filePathString+"/resources/images/"+fileName2);
			BufferedOutputStream bos= new BufferedOutputStream(fosm);
			bos.write(imageBytes);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("Msg");
		mv.addObject("MsgDisplay", "Product Added Sucessfully!!!!1!");
			
			                                    	
		
		return mv;

	}
	@RequestMapping(value="/admin/ViewProducts",method=RequestMethod.GET)
	public ModelAndView fetchProducts(){
		ModelAndView mv=new ModelAndView("ViewProducts");
		List<Product> productList=productDao.getAllProducts();
		
		System.out.println(productList);
		
		mv.addObject("productlist",productList);
		
		return mv;
	}
	


@RequestMapping(value="/admin/deleteProduct/{pId}",method=RequestMethod.GET)
public ModelAndView updateProduct(@PathVariable("pId")int ProductId){
	
	Product productObj=productDao.getProductById(ProductId);
	productDao.deleteProduct(productObj);
	
	ModelAndView mv= new ModelAndView("Msg");
	
	mv.addObject("MsgDisplay","Product Deleted Succesfully");
	mv.addObject("productList",productDao.getAllProducts());

	return mv;
}

}


