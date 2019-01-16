package com.middleware.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daos.BlogDao;
import com.daos.UserDao;
import com.models.Blog;
import com.models.BlogComment;
import com.models.User;


@RestController
public class BlogController {
	
	@Autowired
	BlogDao blogDAO;


	@Autowired
	UserDao userDAO;
	
	@Autowired
	HttpSession session;

	
	@PostMapping(value="/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog){
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setStatus("Pending");
		
		User userDetails=(User)session.getAttribute("userObj");
		System.out.println("User = "+userDetails.getEmail());
		blog.setEmail(userDetails.getEmail());
		
		
		
		if(blogDAO.addBlog(blog)){
			return new ResponseEntity<String>("Blog Added Succesfully",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable int blogId){
		
		
		System.out.println("Delete Blog in Rest Controller : "+blogId);
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blogDAO.deleteBlog(blog)){
			return new ResponseEntity<String>("Blog Deleted Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error in Deleting Blog",HttpStatus.OK);
		}
	}
	
	@PostMapping(value="/updateBlog")
	public ResponseEntity<String> updateBlog(@RequestBody Blog blog){
		System.out.println(blog);
		if(blogDAO.updateBlog(blog)){
			return new ResponseEntity<String>("Blog Updated Succesfully",HttpStatus.OK);
		}
		else{
			return new ResponseEntity<String>("Error in updating blog",HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value="/getBlog/{blogId}")
	public ResponseEntity<Blog> getBlog(@PathVariable int blogId){
		
		Blog blog=blogDAO.getBlog(blogId);
		if(blog==null){
			System.out.println("Blog Not Found");
			return new ResponseEntity<Blog>(blog,HttpStatus.NOT_FOUND);
		}
		else{
			System.out.println("Blog Found "+blog.getBlogName());
			return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		}
	}
	
	
	@GetMapping(value="/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		
		if(blogDAO.approveBlog(blog)){
			return new ResponseEntity<String>("Blog Approved Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error in updating blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable int blogId){
		Blog blog=blogDAO.getBlog(blogId);
		if(blogDAO.rejectBlog(blog)){
			return new ResponseEntity<String>("Blog Rejected Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error in rejecting blog",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(value="/listBlogs")
	public ResponseEntity<List<Blog>> getListBlogs(HttpSession session){
		List<Blog> listBlogs=null;
		User userDetails=(User)session.getAttribute("userObj");
		
			listBlogs=blogDAO.listBlogs(userDetails.getEmail(),userDetails.getRole());
			if(listBlogs.size()>0){
				return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
			}
			else {
				return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.NOT_FOUND);
			}
		
		
	}
	

	
	@GetMapping(value="/listAllApprovedBlogs")
	public ResponseEntity<List<Blog>> getAllListBlogs(){

		List<Blog> listBlogs=blogDAO.listAllApprovedBlogs();
		
		if(listBlogs.size()>0){
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.NOT_FOUND);
		}
	}

	
	@GetMapping(value="/listPendingBlogs")
	public ResponseEntity<List<Blog>> getAllPendingBlogs(){

		List<Blog> listBlogs=blogDAO.listPendingBlogs();
		
		if(listBlogs.size()>0){
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	@GetMapping(value="/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@PathVariable int blogId){
		System.out.println("Increment Liked called : "+blogId); 
		Blog blog=blogDAO.getBlog(blogId);
		blog.setLikes(blog.getLikes()+1);
		blogDAO.incrementLikes(blog);
		return new ResponseEntity<String>("Likes Incremented Succesfully",HttpStatus.OK);
		
	}
	
	
	@PostMapping(value="/addBlogComment")
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogComment,HttpSession session){
		
		blogComment.setCommentDate(new Date());
		
		if(userDAO.getUser(blogComment.getEmail())!=null)
		{
			if(blogDAO.addBlogComment(blogComment)){
				return new ResponseEntity<String>("Blog Comment Added Succesfully",HttpStatus.OK);
			}
			else{
				System.out.println("I m in else");
				return new ResponseEntity<String>("Error in Adding blog Comments",HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		else {
			System.out.println("User doesnt exist");
			System.out.println("I m in else 2");
			return new ResponseEntity<String>("User doesnt exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}

	
	@PostMapping(value="/deleteBlogComment")
	public ResponseEntity<String> deleteBlogComment(@RequestBody BlogComment blogComment,HttpSession session){
		
		boolean r=blogDAO.deleteBlogComment(blogComment);
		
		if(r){
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Comment doesnt exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}

	
	@GetMapping(value="/listAllBlogComments/{blogId}")
	public ResponseEntity<List<BlogComment>> getAllBlogComments(@PathVariable int blogId){

		List<BlogComment> listBlogComments=blogDAO.listBlogComments(blogId);
		
		if(listBlogComments.size()>0){
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/getBlogComment/{commentId}")
	public ResponseEntity<BlogComment> getBlogCommentById(@PathVariable int commentId)
	{
		BlogComment obj=blogDAO.getBlogComment(commentId);
		if(obj==null){
			return new ResponseEntity<BlogComment>(obj,HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<BlogComment>(obj,HttpStatus.OK);
		}
	}
	
	
	 
}




