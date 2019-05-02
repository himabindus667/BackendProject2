package com.coll.dao;

import java.util.List;

import com.coll.model.BlogComment;



public interface BlogCommentDAO 
{
	 public boolean addBlogComment(BlogComment blogComment);
	   public boolean deleteBlogComment(BlogComment blogComment);
	   public boolean updateBlogComment(BlogComment blogComment);
	   public List<BlogComment> listBlogComment();
	   public BlogComment getBlogComment(int commentId);

}
