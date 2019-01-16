package com.project2.backendproject;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DBConfig;
import com.daos.ForumDao;
import com.daos.UserDao;
import com.daosimpl.ForumDaoImpl;
import com.models.Blog;
import com.models.Forum;
import com.models.User;

public class ForumDaoTest {
	
	static ForumDao forumDao;
	
	@BeforeClass
	public static void init(){
	AnnotationConfigApplicationContext context=new 	AnnotationConfigApplicationContext();
	context.register(DBConfig.class);	
	context.refresh();
	
	forumDao=context.getBean("forumDao",ForumDao.class);
	}

@Test
@Ignore
public void addForumDaoTest()
{

	 {
			Forum forum=new Forum();
			forum.setEmail("animesh@gmail.com");
			forum.setForumContent("contnt1");
			forum.setForumName("name1");
			forum.setStatus("offline");
			
			assertTrue("forum Not Added",forumDao.addForum(forum)); 
	 System.out.println("heloo i m running");}
}
		

			//@Test

 			@Ignore
			public void updateForumDaoTest(){
			Forum forum=forumDao.getForum(200);
			forum.setForumName("Blog Test1 ");
			forum.setForumContent("Test Desc1");
			forum.setEmail("Blogtest1@gmail.com");
			boolean r=forumDao.updateForum(forum);
     
    assertTrue("Problem in updating Blog",r);
    System.out.println("Updating done..");
}


			 
			 //@Test
				@Ignore
				public void deleteForumDaoTest(){
					Forum forum=forumDao.getForum(50);
					if(forum!=null){
						boolean r=forumDao.deleteForum(forum);
						assertTrue("Problem in deleting Forum",r);
					}
					else {
			         assertNotNull("Forum Not Found",forum);
					}
			 }
				
					  //@Test
				        @Ignore
				        public void approveForumDaoTest(){
				        	Forum forum=forumDao.getForum(200);
				        	forum.setStatus("Approved");
				        	boolean r=forumDao.approveForum(forum);
				        	
				        	assertTrue("cannot be approved",r);
				        	System.out.println("approved working....");
				        }
					  //@Test
				        @Ignore
				        public void rejectForumDaoTest(){
				        	Forum forum=forumDao.getForum(250);
				        	forum.setStatus("Rejected");
				        	boolean r=forumDao.approveForum(forum);
				        	
				        	assertTrue("not found in database",r);
				        	System.out.println("rejected blog working....");
				        }
					  //@Test
						@Ignore
						public void listForumDaoTest ()
						{
							List<Forum> forumList=forumDao.listForums("Blogtest1@gmail.com", null);
							for(Forum forum:forumList){
								System.out.println(forum.getForumName()+" "+forum.getForumContent());
							}
							assertTrue("Blogs Not Found", forumList.size()>0);
							System.out.println("list working....");
							
						}
				}

		
		
		
		
