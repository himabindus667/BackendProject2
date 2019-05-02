package com.coll.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserRoleDAO;
import com.coll.model.UserRole;

public class UserRoleDAOTest
{
	static UserRoleDAO userRoleDAO;
	
	
	@BeforeClass
	 public static void initialize()
	 {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		userRoleDAO=(UserRoleDAO)context.getBean("userRoleDAO");
		
	 }
	
	@Test
	public void registerUserTest()
	{
		UserRole user=new UserRole();
		user.setEmailId("himabindus667@gmail.com");
		user.setIsOnline("Online");
		user.setUsername("bindu");
		user.setPassword("bindu123");
		user.setStatus("NA");
		user.setRole("ROLE_USER");
		user.setMemberName("HimaBindu");
		
		
	assertTrue("Problem in registering the User:",userRoleDAO.registerUser(user));
	}



}
	
