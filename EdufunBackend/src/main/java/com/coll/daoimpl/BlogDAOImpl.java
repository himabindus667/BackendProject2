package com.coll.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO
 
{
	@Autowired
	SessionFactory sessionFactory;

	
	

	public boolean addBlog(Blog blog) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(blog);
			return true;
		
	}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean deleteBlog(Blog blog)
	{
		try
        {
        sessionFactory.getCurrentSession().delete(blog);
        return true;
        }
        catch(Exception e)
        {
        return false;
        }
	}
	

	public boolean updateBlog(Blog blog) 
	{	
		try
    {
    sessionFactory.getCurrentSession().update(blog);
    return true;
    }
    catch(Exception e)
    {
    return false;
}

	}

	public List<Blog> listBlog() {
		  Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from Blog");
	        List<Blog> listBlog=query.list();
	        session.close();
			return listBlog;
	}
	
	public Blog getBlog(int blogId) 
	{
        Session session=sessionFactory.openSession();
        Blog blog=(Blog) session.get(Blog.class, blogId);    
		return blog ;
	}
	
}


