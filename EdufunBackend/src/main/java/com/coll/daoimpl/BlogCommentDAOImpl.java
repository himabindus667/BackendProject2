package com.coll.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.dao.BlogCommentDAO;

import com.coll.model.BlogComment;


@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment blogComment) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(blogComment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogComment)
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateBlogComment(BlogComment blogComment) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(blogComment);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<BlogComment> listBlogComment() 
	{
		Session session=sessionFactory.openSession();
        Query query=session.createQuery("from BlogComment");
        List<BlogComment> listBlog=query.list();
        session.close();
		return listBlogComment();
	}

	

	@Override
	public BlogComment getBlogComment(int commentId) 
	{
		 Session session=sessionFactory.openSession();
	        BlogComment blogComment=(BlogComment) session.get(BlogComment.class, commentId);    
			return blogComment;
	
	}

}
