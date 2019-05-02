package com.coll.test;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogCommentDAO;

import com.coll.model.BlogComment;

public class BlogCommentDAOTest
{
	static BlogCommentDAO blogCommentDAO;
	@BeforeClass
	public static void initialize() 
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
	}
	
   @Ignore
	@Test
	public void addBlogCommentTest()
	{
		BlogComment blogComment=new BlogComment();
		blogComment.setUsername("prudvi");
		
		blogComment.setCommentText("The blog for learning java component");
		blogComment.setBlogId(3);
		blogComment.setCreateDate(new java.util.Date());
		assertTrue("Problem in adding the BlogComment",blogCommentDAO.addBlogComment(blogComment));
	}
	
	@Ignore
	@Test
	public void updateBlogCommentTest()
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(50);
		
		
		blogComment.setCommentText("about technology");
		
		assertTrue("problem in updating the blogComment",blogCommentDAO.updateBlogComment(blogComment));
	}

	@Ignore
	@Test
	public void deleteBlogCommentTest()
	{
		BlogComment blogComment=blogCommentDAO.getBlogComment(150);
		
		assertTrue("problem in deleting the blog",blogCommentDAO.deleteBlogComment(blogComment));
	}
	
	@Ignore
	@Test
	public void listBlogCommentTest()
	{
			List<BlogComment> listBlogComment=blogCommentDAO.listBlogComment();
			
			assertTrue("Problem in Listing BlogComment",listBlogComment.size()>0);
			
			for(BlogComment blogComment:listBlogComment)
			{
			
				System.out.print(blogComment.getUsername()+"\t");
				System.out.print(blogComment.getCommentText()+"\t");
							
			}
	}
	


}
