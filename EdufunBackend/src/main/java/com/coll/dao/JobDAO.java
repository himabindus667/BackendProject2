package com.coll.dao;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO 
{
	public boolean addJob(Job job);
	public List<Job> showJobs(Job job);
	public Job getJob(int jobId);

}
