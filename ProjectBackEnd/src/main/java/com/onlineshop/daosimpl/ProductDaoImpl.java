package com.onlineshop.daosimpl;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.daos.ProductDao;
import com.onlineshop.daos.SupplierDao;
import com.onlineshop.models.Product;
import com.onlineshop.models.Supplier;



@Repository("PrdouctDao") /*is used to indicate that the class provides the mechanism for storage, 
						   retrieval, search, update and delete operation on objects.*/
@Transactional  /*The transactional annotation itself defines the scope of a single database transaction. 
				The database transaction happens inside the scope of a persistence context.*/

public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean addProduct(Product productObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(productObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


	@Override
	public boolean deleteProduct(Product ProductObj) {
		try {
			Session session=sessionFactory.getCurrentSession();;
			session.delete(ProductObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


	@Override
	public boolean updateProduct(Product product) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(product);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


	@Override
	public Product getProductById(int ProductId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Product productObj=(Product)session.get(Product.class,ProductId);
			return productObj;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}


	@Override
	public List<Product> getAllProducts() {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria cr=session.createCriteria(Product.class);
			List<Product> list=cr.list();
			return list;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}


	@Override
	public List<Product> getAllProductsByCategory(int categoryId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria cr=session.createCriteria(Product.class);
			cr.add(Restrictions.eq ("categoryId", categoryId) );
			List<Product> list=cr.list();
			return list;
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		

		return null;
	

	
	}
	
}

