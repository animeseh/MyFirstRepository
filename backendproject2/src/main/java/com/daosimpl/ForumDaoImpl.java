package com.daosimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.daos.ForumDao;

import com.models.Forum;
import com.models.ForumComment;
import com.models.Job;

@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addForum(Forum forum) {
		try{
			Session session =sessionFactory.getCurrentSession();
			session.saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try{
			Session session =sessionFactory.getCurrentSession();
			session.delete(forum);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}return false;
	}

	@Override
	public boolean updateForum(Forum forum) {
		try{
			Session session =sessionFactory.getCurrentSession();
			session.update(forum);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}return false;
	}

	@Override
	public Forum getForum(int forumId) {
		try{
			Session session =sessionFactory.getCurrentSession();
			Job jobobj=(Job)session.get(Job.class, forumId);
			return getForum(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}return null;
	}

	@Override
	public boolean approveForum(Forum forum) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(forum);
			return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public boolean rejectForum(Forum forum) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(forum);
			return true;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return false;
	}
		

	@Override
	public List<Forum> listForums(String userName, String role) {
		try{
			Session session =sessionFactory.getCurrentSession();
			Query querry=session.createQuery("from Blog where email=:abc");
			querry.setParameter("abc",addForum(null));
			List<Forum> blogList=querry.list();
			return blogList;
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addForumComment(ForumComment ForumComment) {
		try{
			Session session =sessionFactory.getCurrentSession();
			session.saveOrUpdate(ForumComment);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}return false;
	}

	@Override
	public boolean deleteForumComment(ForumComment ForumComment) {
		try{
			Session session =sessionFactory.getCurrentSession();
			session.delete(ForumComment);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}return false;
	}

	@Override
	public ForumComment getForumComment(int commentId) {
			try{
				Session session =sessionFactory.getCurrentSession();
				ForumComment forumcom=(ForumComment)session.get(ForumComment.class,commentId);
				return forumcom;
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		return null;
	}

	@Override
	public List<ForumComment> listForumComments(int ForumId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query querry=session.createQuery("from BlogComment");
			List<ForumComment> forumCommentList=querry.list();
			return forumCommentList;
		
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;
}

}



