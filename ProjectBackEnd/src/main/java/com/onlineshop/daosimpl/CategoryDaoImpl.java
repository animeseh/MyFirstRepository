package com.onlineshop.daosimpl;



import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.models.Category;



@Repository("CategoryDao") /*is used to indicate that the class provides the mechanism for storage, 
						   retrieval, search, update and delete operation on objects.*/

@Transactional  /*The transactional annotation itself defines the scope of a single database transaction. 
				The database transaction happens inside the scope of a persistence context.*/

public class CategoryDaoImpl implements com.onlineshop.daos.CategoryDao{
	@Autowired
	SessionFactory sessionFactory;
	

	public boolean addCategory(Category CategoryObj) {
		try {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(CategoryObj);
		return true;
		}
		catch(Exception e){
		e.printStackTrace();
		return false;
		}
}


	public boolean deleteCategory(Category CategoryObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(CategoryObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


	public boolean updateCategory(Category Category) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(Category);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


	public Category getCategoryById(int categoryId) {
		try{
		Session session=sessionFactory.getCurrentSession();
		Category categoryObj=(Category)session.get(Category.class,categoryId);
		return categoryObj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	
	




	@Override
	public List<Category> getAllCategories() {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Category");
			List<Category> list=query.getResultList();
				return list;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

}



				