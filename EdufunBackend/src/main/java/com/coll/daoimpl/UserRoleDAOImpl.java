package com.coll.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.dao.UserRoleDAO;
import com.coll.model.Blog;
import com.coll.model.UserRole;

@Repository("userRoleDAO")
@Transactional
public class UserRoleDAOImpl implements UserRoleDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean registerUser(UserRole user) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
		    session.save(user);
			return true;
		
	}
		catch(Exception e)
		{
		return false;
		}
	
	}

	@Override
	public boolean updateUser(UserRole user) 

{
		try
		{
			Session session=sessionFactory.getCurrentSession();
		    session.update(user);
			return true;
		
	}
		catch(Exception e)
		{
		return false;
		}
		
	}

	@Override
	public UserRole checkUser(UserRole user) 

{
		  Session session=sessionFactory.openSession();
	        Query query=session.createQuery("from userRole where username:uname and password:passwd");
	        query.setParameter("uname",user.getUsername());
	        query.setParameter("passwd",user.getPassword());
	        List<UserRole> listUser=query.list();
	       if(listUser.size()>0)
	       {
	    	   return listUser.get(0);
	    	   
	       }
	       else
	       {
	    	   return null;
	    	   
	       }
		
		
	}

	@Override
	public UserRole getUser(String username) 
	{
        Session session=sessionFactory.openSession();
        UserRole user=(UserRole) session.get(UserRole.class,username);    
		return user ;
		
	}



}
