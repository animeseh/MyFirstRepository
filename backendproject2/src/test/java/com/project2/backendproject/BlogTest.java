
package com.project2.backendproject;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DBConfig;
import com.daos.BlogDao;
import com.models.Blog;
import com.models.BlogComment;

public class BlogTest {

	static BlogDao blogDao;
	@BeforeClass
	 public static void init(){
	        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	        context.register(DBConfig.class);
	        context.refresh();
	        
	        blogDao=context.getBean("blogDao",BlogDao.class);
	    }
	
	 @Test
	 @Ignore
	 public void test(){
		 Blog blog=new Blog();
		 blog.setBlogName("Collections Framework");
		 blog.setBlogContent("Collections Framework was introduced in JDK 1.2");
		 
		 Date d=new Date();
		 blog.setCreateDate(d);
		 
		 blog.setLikes(0);
		 blog.setEmail("Animesh");
		 blog.setStatus("Pending");
		 
		 assertTrue("Blog Not Added",blogDao.addBlog(blog));
		 
	}
	 
	 
	 
	 @Test
		@Ignore
		public void deleteBlog(){
			Blog blog=blogDao.getBlog(50);
			if(blog!=null){
				boolean r=blogDao.deleteBlog(blog);
				assertTrue("Problem in deleting Blog",r);
			}
			else {
	         assertNotNull("Blog Not Found",blog);
			}
	        }
	         
	         
		
	        @Test
	        
	        @Ignore
	        public void updateBlog(){
	        	Blog blog=blogDao.getBlog(200);
	            blog.setBlogName("Blog Test1 ");
	            blog.setBlogContent("Test Desc1");
	            blog.setEmail("Blogtest1@gmail.com");
	            boolean r=blogDao.updateBlog(blog);
	             
	            assertTrue("Problem in updating Blog",r);
	            System.out.println("Updating done..");
	        }
	    
	        
	        @Test
	        @Ignore
	        public void approveBlog(){
	        	Blog blog=blogDao.getBlog(200);
	        	blog.setStatus("Approved");
	        	boolean r=blogDao.approveBlog(blog);
	        	
	        	assertTrue("cannot be approved",r);
	        	System.out.println("approved working....");
	        }
	        @Test
	        @Ignore
	        public void rejectBlog(){
	        	Blog blog=blogDao.getBlog(250);
	        	blog.setStatus("Rejected");
	        	boolean r=blogDao.approveBlog(blog);
	        	
	        	assertTrue("not found in database",r);
	        	System.out.println("rejected blog working....");
	        }
	        
	        @Test
	        @Ignore
	        public void incrementLikes(){
	        	Blog blog=blogDao.getBlog(250);
	        	blog.setLikes(blog.getLikes()+1);
	        	boolean r=blogDao.incrementLikes(blog);
	        	
	        	assertTrue("blog not found",r);
	        	System.out.println("Inrement done..");
	        }
	        
	        
	        
	        @Test
	        @Ignore
	        public void getBlog(){
	        	Blog blog=blogDao.getBlog(200);
	        	if(blog !=null){
	        	
					System.out.println(blog);
	        	}
	            assertNotNull("Blog Not Found", blog);
	            System.out.println("blog found...");
	        }
	        
	        @Test
	        @Ignore
	        public void getAllApprovedBlogs(){
	        	List<Blog> blogs=blogDao.listAllApprovedBlogs();
	        	for(Blog blog:blogs)
	        	{
	        		System.out.println(blog.getBlogContent()+ " " +blog.getStatus());
	        	}
	        	
	        	assertTrue("Approved Blogs Not Found",blogs.size()>0);
	        } 
	        
	        @Test
	        @Ignore
	        public void getAllPendingBlogs(){
	        	List<Blog> blogs=blogDao.listPendingBlogs();
	        	for(Blog blog:blogs)
	        	{
	        		System.out.println(blog.getBlogContent());
	        	}
	        	
	        	assertTrue("Pending Blogs Not Found",blogs.size()>0);
	        	System.out.println("pending working");
	        } 
	        
	        @Test
	    	@Ignore
	    	public void addBlogComment(){
	    		BlogComment blogComment=new BlogComment();
	    		blogComment.setCommentText("Impressive");
	    		blogComment.setEmail("rahul@gmail.com");
	    		blogComment.setBlogId(200);
	    		Date d=new Date();
	    		blogComment.setCommentDate(d);
	    		
	    		assertTrue("Blog Comment Not Added",blogDao.addBlogComment(blogComment));
	    		System.out.println("BVlog comment working");
	    	}
	        @Test
	    	@Ignore
	    	public void deleteBlogComment(){
	    		BlogComment blogComment=blogDao.getBlogComment(50);
	    		boolean r=blogDao.deleteBlogComment(blogComment);
	             assertTrue("Problem in deleting Comment",r);
	             System.out.println("delete comment working");
	            }
	        
	        @Test
	        @Ignore
	        public void getBlogComment(){
	        	BlogComment blogComment=blogDao.getBlogComment(100);
	            assertNotNull("Blog Comment Not Found", blogComment);
	        System.out.println("blog comment working");
	        }
			
			@Test
			@Ignore
			public void listBlogComment(){
				List<BlogComment> commentList=blogDao.listBlogComments(200);
				for( BlogComment comment:commentList ){
				System.out.println(comment.getCommentText());
			}
			
			assertTrue("No comment found",commentList.size()>0);
				
			}
			
			@Test
			@Ignore
			public void listBlog ()
			{
				 List<Blog> blogList=blogDao.listBlogs("Blogtest1@gmail.com","Role_User");
		            for(Blog blog:blogList){
		                System.out.println(blog.getBlogName()+" "+blog.getBlogContent());
		            }
		            assertTrue("Blogs Not Found", blogList.size()>0);
		            System.out.println("list working....");
		             
		        }
		}