package com.onlineshop.ProjectBackEnd;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.daos.ProductDao;
import com.onlineshop.daos.SupplierDao;
import com.onlineshop.models.Supplier;

public class SupplierTestCase {


	static SupplierDao supplierObj;
	
	@BeforeClass /*as soon as this class will get instialized this class will be called bzs of this annotattion*/
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.onlineshop");
		
		app.refresh();
		supplierObj=app.getBean("supplierDao",SupplierDao.class);
	
		
	}
	
	@Test /* To run only the selected test, position the cursor on the test method name and use the shortcut. */
	@Ignore
	public void addSupplierTest(){
		Supplier supp=new Supplier();
		supp.setSupplierName("Balaji Telecom");
		supp.setSupplierAddress("Pahar Ganj");
		
		boolean r=supplierObj.addSupplier(supp);
		
		/*This test will fail if value of r is false . */
		assertTrue("Problem in Adding Supplier",r);
	}
	
	@Test
	@Ignore
	public void deleteSupplier(){
		Supplier cat=supplierObj.getSupplierById(32);
		boolean r=supplierObj.deleteSupplier(cat);
		
		assertTrue("Problem in deleting Supplier",r);
		
		
		
	}
	
	
		@Test
		@Ignore
		public void updateCategory(){
			Supplier s=supplierObj.getSupplierById(34);
			s.setSupplierAddress("Karol Bagh");
			boolean r=supplierObj.updateSupplier(s);
			assertTrue("Problem in updating Supplier",r);
		}
		
			
		@Test
		@Ignore
		public void getSupplierId(){
			Supplier catObj=supplierObj.getSupplierById(34);
			System.out.println(catObj);
			assertNotNull("Supplier Not Found", catObj);
		}

		
		@Test
		@Ignore
		public void getAllSuppliers(){
			List<Supplier> supplierList=supplierObj.getAllSuppliers();
			System.out.println(supplierList);
			assertNotNull("Suppliers Not Found", supplierList);
		}


				
	}
	
	
	

	
	

	