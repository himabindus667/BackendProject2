package com.coll.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;



public class BlogDAOTest 
{
    static BlogDAO blogDAO;
	
	@BeforeClass
	public static void initialize() 
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
		blogDAO=(BlogDAO)context.getBean("blogDAO");
	}
	
    @Ignore
	@Test
	public void addBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlogName("Bindu");
		blog.setBlogContent("About me");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(1);
		blog.setDislikes(0);
		blog.setStatus("NA");
		blog.setUsername("bindu");
		
		assertTrue("Problem in adding the Blog",blogDAO.addBlog(blog));
	}
	
	@Ignore
	@Test
	public void updateBlogTest()
	{
		Blog blog=blogDAO.getBlog(50);
		
		blog.setBlogContent("This blog is to discuss about life of me");
		assertTrue("problem in updating the blog",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=blogDAO.getBlog(1050);
		
		assertTrue("problem in deleting the blog",blogDAO.deleteBlog(blog));
	}
	
	
	@Test
	public void listBlogTest()
	{
			List<Blog> listBlogs=blogDAO.listBlog();
			
			assertTrue("Problem in Listing Blog",listBlogs.size()>0);
			
			for(Blog blog:listBlogs)
			{
			
				System.out.print(blog.getBlogName()+"\t");
				System.out.print(blog.getBlogContent()+"\t");
				System.out.println(blog.getStatus());				
			}
	}
	

}