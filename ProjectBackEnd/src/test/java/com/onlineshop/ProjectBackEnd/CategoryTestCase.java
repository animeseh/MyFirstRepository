package com.onlineshop.ProjectBackEnd;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.daos.CategoryDao;
import com.onlineshop.daos.SupplierDao;
import com.onlineshop.daos.UserDao;
import com.onlineshop.models.Category;
import com.onlineshop.models.Supplier;

public class CategoryTestCase {
static CategoryDao categoryObj;
	
	@BeforeClass /*as soon as this class will get instialized this class will be called bzs of this annotattion*/
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.onlineshop");
		
		app.refresh();
		categoryObj=app.getBean("CategoryDao",CategoryDao.class);
		
	}
	
	@Test /* To run only the selected test, position the cursor on the test method name and use the shortcut. */
	@Ignore
	public void addCategoryTest(){
		Category cat=new Category();
		cat.setCategoryName("Mens News Fashion Desingining Showroom");
		cat.setCategoryDescription("Mens Clothing");
		
		boolean r=categoryObj.addCategory(cat);
		
		/*This test will fail if value of r is false . */
		assertTrue("Problem in Adding Category",r);
	}
	
	
	@Test
	@Ignore
	public void deleteCategory(){
		Category cat=categoryObj.getCategoryById(37);
		boolean r=categoryObj.deleteCategory(cat);
		
		assertTrue("Problem in deleting Category",r);
		
		 	 	 	
		
	}
	
	
		@Test
		@Ignore
		public void updateCategory(){
			Category s=categoryObj.getCategoryById(36);
			s.setCategoryName("Kids");
			s.setCategoryDescription("Kids Clothing");
			boolean r=categoryObj.updateCategory(s);
			assertTrue("Problem in updating Category",r);
		}
		
			
		@Test
		@Ignore
		public void getCategoryId(){
			Category catObj=categoryObj.getCategoryById(36);
			System.out.println(catObj);
			assertNotNull("Category Not Found", catObj);
		}

		
		@Test
		@Ignore
		public void getAllCategories(){
			List<Category> categoryList=categoryObj.getAllCategories();
			System.out.println(categoryList);
			assertNotNull("Categories Not Found", categoryObj);
		}


				
	}
	
	
	

	
	

	