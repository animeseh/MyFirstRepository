package com.daosimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





import com.daos.UserDao;
import com.models.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	  @Autowired
	    SessionFactory sessionFactory;
	     

	@Override
	public boolean registerUser(User userObj) {
		 try{
		        Session session=sessionFactory.getCurrentSession();
		        session.save(userObj);
		        return true;
		        }
		        catch(Exception e){
		            e.printStackTrace();
		        }
		return false;
	}

	@Override
	public boolean checkLogin(User userObj) {
		 try{
		        Session session=sessionFactory.getCurrentSession();
		        Query query=session.createQuery("from User where email=:a and password=:b");
		        query.setParameter("a",userObj.getEmail());
		        query.setParameter("b",userObj.getPassword());
		         
		        List<User> userList=query.list();
		        if(userList.size()!=0){
		            return true;
		        }
		        }
		        catch(Exception e){
		            e.printStackTrace();
		        }
		return false;
	}

	@Override
	public boolean updateOnlineStatus(String status, String email) {
		 try{
		        Session session=sessionFactory.getCurrentSession();
		        User userObj=(User)session.get(User.class,email);
		        userObj.setOnlineStatus(status);
		         
		        return true;
		        }
		        catch(Exception e){
		            e.printStackTrace();
		        }
		return false;
	}

	@Override
	public User getUser(String email) {
		  try{
		        Session session=sessionFactory.getCurrentSession();
		        User obj=(User)session.get(User.class,email);
		        return obj;
		        }
		        catch(Exception e){
		            e.printStackTrace();
		        }
		return null;
	}

	@Override
	public List<User> getUsers() {
		 try{
		        Session session=sessionFactory.getCurrentSession();
		        Query query=session.createQuery("from User");
		        List<User> users=query.list();
		        return users;
		        }
		        catch(Exception e){
		            e.printStackTrace();
		        }
		        return null;
		    }

	@Override
	public boolean deleteUser(User userObj) {
	     try{    
	            Session session=sessionFactory.getCurrentSession();
	            session.delete(userObj);
	            return true;
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	        return false;
	    }

	@Override
	public boolean updateUser(User userObj) {
		 try{
	            Session session=sessionFactory.getCurrentSession();
	            session.update(userObj);
	            return true;    
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	
		
	}


