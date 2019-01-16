package com.daos;

import java.util.List;

import com.models.Blog;
import com.models.BlogComment;



public interface BlogDao {
	  public boolean addBlog(Blog blog);
	    public boolean deleteBlog(Blog blog);
	    public boolean updateBlog(Blog blog);
	    public Blog getBlog(int blogId);
	    public boolean approveBlog(Blog blog);
	    public boolean rejectBlog(Blog blog);
	    public List<Blog> listBlogs(String email,String role);
	    public List<Blog> listAllApprovedBlogs();
	    public List<Blog> listPendingBlogs();
	    public boolean incrementLikes(Blog blog);
	     
	    public boolean addBlogComment(BlogComment blogComment);
	    public boolean deleteBlogComment(BlogComment blogComment);
	    public BlogComment getBlogComment(int commentId);
	    public List<BlogComment> listBlogComments(int blogId);
	 
	}   
	    
	    
	    
	   
	     
	
	     
	

