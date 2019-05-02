package com.coll.dao;

import com.coll.model.UserRole;

public interface UserRoleDAO 
{
	public boolean registerUser(UserRole user);
	public boolean updateUser(UserRole user);
	public UserRole checkUser(UserRole user);
	public UserRole getUser(String username);
}
