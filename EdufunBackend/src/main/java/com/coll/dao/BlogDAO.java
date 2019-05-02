package com.coll.dao;

import java.util.List;

import com.coll.model.Blog;

public interface BlogDAO 
{
	  public boolean addBlog(Blog blog);
	   public boolean deleteBlog(Blog blog);
	   public boolean updateBlog(Blog blog);
	   public List<Blog> listBlog();
	   public Blog getBlog(int blogId);

}
