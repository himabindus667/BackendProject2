package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDAO;
import com.coll.model.Job;

public class JobDAOTest
{
	
	static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		jobDAO=(JobDAO)context.getBean("jobDAO");
		
	}


	@Ignore
	@Test
	public void addJobTest()
	{
		Job job=new Job();
		job.setDesignation("Deveops");
		job.setCompanyName("Wipro");
		job.setJobDesc("Need to have knowledge Java");
		job.setCTC(30000);
		job.setJobLocation("Hyderabad");
		job.setSkills("Java,Hibernate");
		job.setLastDatetoApply(new java.util.Date(2019, 05, 30));
		
		assertTrue("Problem in adding the job",jobDAO.addJob(job));
	}
	@Ignore
	@Test
	public void showJobTest()
	{
	
		List<Job> jobList=jobDAO.showJobs();
		assertTrue("Problem in Listing the Job",jobList.size()>0);
		
		for(Job job:jobList)
		{
			System.out.println(job.getDesignation()+"::");
			System.out.println(job.getJobDesc()+"::");
			System.out.println(job.getCompanyName()+"::");
			System.out.println(job.getLastDatetoApply()+"");
					
			
			
			
		}
	
	}

}
