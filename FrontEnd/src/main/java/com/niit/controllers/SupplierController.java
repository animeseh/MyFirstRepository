package com.niit.controllers;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.daos.SupplierDao;

import com.onlineshop.models.Supplier;


@Controller
public class SupplierController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping(value="/admin/getSupplierForm",method=RequestMethod.GET)
	public ModelAndView getAddSupplierForm(){
		System.out.println("I m in get Add Supplier Form");
		ModelAndView mv= new ModelAndView("SupplierForm");
		mv.addObject("sObj",new Supplier());
		mv.addObject("heading","Add SupplierForm");
		mv.addObject("button","Add Supplier ");
		return mv;
	}
	
	
	@RequestMapping(value="/admin/addSupplierProcess",method=RequestMethod.POST)
	public ModelAndView addSupplier(@ModelAttribute("sobj")Supplier sobj){
	
		
		
		ModelAndView mv=new ModelAndView("ViewSuppliers");
		if(sobj.getSupplierId()==0){
			mv.addObject("msgToDisplay","Supplier Added");
		
		}
		else{
			
			mv.addObject("msgToDisplay", "Supplier Updated");
		}
		supplierDao.addSupplier(sobj);
		mv.addObject("supplierList",supplierDao.getAllSuppliers());
		
		
		
		return mv;
	}
	
	
	@RequestMapping(value="/admin/ViewSuppliers",method=RequestMethod.GET)
	public ModelAndView fetchSuppliers(){
		ModelAndView mv=new ModelAndView("ViewSuppliers");
		List<Supplier> supplierList=supplierDao.getAllSuppliers();
		
		System.out.println(supplierList);
		
		mv.addObject("supplierList",supplierList);
		
		return mv;
	}
	
	@RequestMapping(value="/admin/deleteSupplier/{sId}",method=RequestMethod.GET)
	public ModelAndView deleteSupplier(@PathVariable("sId")int supplierId){
		
		Supplier sObj=supplierDao.getSupplierById(supplierId);
		supplierDao.deleteSupplier(sObj);
		
		
		ModelAndView mv= new ModelAndView("ViewSuppliers");
		mv.addObject("msgToDisplay","Supplier Deleted Succesfully");
		mv.addObject("supplierList",supplierDao.getAllSuppliers());
		return mv;
	}
	
	@RequestMapping(value="/admin/updateSupplier/{sId}",method=RequestMethod.GET)
	public ModelAndView updateSupplier(@PathVariable("sId")int supplierId){
		
		Supplier suppObj=supplierDao.getSupplierById(supplierId);
	
		
		ModelAndView mv= new ModelAndView("SupplierForm");
		
		/*sObj is the name we have written in the model attribute of SupplierForm.jsp*/
		mv.addObject("sObj", suppObj);
		mv.addObject("heading","Update SupplierForm");
		mv.addObject("button","Update Supplier ");
		return mv;
	}
	
}

