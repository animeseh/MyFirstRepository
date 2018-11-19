package com.onlineshop.ProjectBackEnd;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.daos.CategoryDao;
import com.onlineshop.daos.ProductDao;
import com.onlineshop.daos.UserDao;
import com.onlineshop.models.Category;
import com.onlineshop.models.Product;
public class ProductTestCase {
static ProductDao productObj;
	
	@BeforeClass /*as soon as this class will get instialized this class will be called bzs of this annotattion*/
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.onlineshop");

		app.refresh();
		productObj=app.getBean("PrdouctDao",ProductDao.class);
		

	}
	
	@Test /* To run only the selected test, position the cursor on the test method name and use the shortcut. */
	@Ignore
	public void addProductTest(){
		Product cat=new Product();
		cat.setProductName("New Mobile Store");
		cat.setProductDescription("Mobile Shop");
		
		boolean r=productObj.addProduct(cat);
		
		/*This test will fail if value of r is false . */
		assertTrue("Problem in Adding Product",r);
	}
	
	
	@Test
	@Ignore
	public void deleteProduct(){
		Product cat=productObj.getProductById(37);
		boolean r=productObj.deleteProduct(cat);
		
		assertTrue("Problem in deleting Product",r);
		
		 	 	 	
		
	}
	
	
		@Test
		@Ignore
		public void updateProduct(){
			Product s=productObj.getProductById(36);
			s.setProductName("Kids");
			s.setProductDescription("Kids Clothing");
			boolean r=productObj.updateProduct(s);
			assertTrue("Problem in updating Product",r);
		}
		
			
		@Test
		@Ignore
		public void getProductId(){
			Product p=productObj.getProductById(36);
			System.out.println(p);
			assertNotNull("Product Not Found", p);
		}

		
		@Test
		@Ignore
		public void getAllProducts(){
			List<Product> productList=productObj.getAllProducts();
			System.out.println(productList);
			assertNotNull("Products Not Found",productObj);
		}


				
	
	
	
	@Test
	@Ignore
	public void getAllProductsByCategory() {
		
		List<Product> productList=productObj.getAllProductsByCategory(1);
		System.out.println(productList);
		assertNotNull("Products Not Found", productList);
}
	}

	
	

	

