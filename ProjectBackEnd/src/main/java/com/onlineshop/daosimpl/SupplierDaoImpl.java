package com.onlineshop.daosimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.daos.SupplierDao;
import com.onlineshop.models.Supplier;



@Repository("supplierDao") /*is used to indicate that the class provides the mechanism for storage, 
						   retrieval, search, update and delete operation on objects.*/
@Transactional  /*The transactional annotation itself defines the scope of a single database transaction. 
				The database transaction happens inside the scope of a persistence context.*/

public class SupplierDaoImpl implements SupplierDao {
	@Autowired
	SessionFactory sessionFactory;
	

	public boolean addSupplier(Supplier SupplierObj) {
		try {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(SupplierObj);
		return true;
		}
		catch(Exception e){
		e.printStackTrace();
		return false;
		}
}


	public boolean deleteSupplier(Supplier SupplierObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(SupplierObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


	public boolean updateSupplier(Supplier Supplier) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(Supplier);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


	public Supplier getSupplierById(int SupplierId) {
		try{
		Session session=sessionFactory.getCurrentSession();
		Supplier cObj=(Supplier)session.get(Supplier.class,SupplierId);
		return cObj;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Supplier> getAllSuppliers() {
		try{
		Session session=sessionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Supplier.class);
		List<Supplier> list=cr.list();
		return list;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}


