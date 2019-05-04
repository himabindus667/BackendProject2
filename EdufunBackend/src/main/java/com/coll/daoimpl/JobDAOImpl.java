package com.coll.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.dao.JobDAO;
import com.coll.model.Job;


@Repository("jobDAO")
@Transactional
public class JobDAOImpl implements JobDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addJob(Job job) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(job);
			return true;
		
	}
		catch(Exception e)
		{
		return false;
		}
	
	}

	@Override
	public List<Job> showJobs(Job job) 
	{
		
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(Job.class);
		criteria.add(Restrictions.ge("lastDatetoApply",new java.util.Date()));
		List<Job> joblist=criteria.list();
		session.close();
		
		
		return joblist;
		
	}

	@Override
	public Job getJob(int jobId) 
	{
		Session session=sessionFactory.openSession();
		Job job=(Job) session.get(Job.class, jobId);
		session.close();
		
		
		return job;
	}

}
