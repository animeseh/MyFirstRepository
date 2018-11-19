package com.onlineshop.daosimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.daos.UserDao;
import com.onlineshop.models.Address;
import com.onlineshop.models.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(User user) {
		try{
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User validateUser(String email, String password) {
		try{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where email=:a and password=:b");
		query.setParameter("a", email);
		query.setParameter("b",password);
		List list=query.getResultList();
		if(list.size()!=0){
			return (User)list.get(0);
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addAddress(Address address) {
		try{
		Session session=sessionFactory.getCurrentSession();
		session.save(address);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Address getAddress(int addressId) {
		try{
		Session session=sessionFactory.getCurrentSession();
		Address addr=session.get(Address.class, addressId);
		return addr;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteAddress(Address address) {
		try{
		Session session=sessionFactory.getCurrentSession();
		session.delete(address);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateAddress(Address address) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(address);	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Address> getAllAddressForUser(String email) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria cr=session.createCriteria(Address.class);
			cr.add(Restrictions.eq("user.email", email));
			List<Address> addressList=cr.list();
			return addressList;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	

	  @Override
	    public User getUser(String email) {
	        Session session=sessionFactory.getCurrentSession();
	        User user=session.get(User.class, email);
	        return user;
	         
	    }




	 
	     
	 
	}


