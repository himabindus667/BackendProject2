package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@SequenceGenerator(name="jobid_seq",sequenceName="jobidseq")
public class Job 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobid_seq")
	int JobId;
	String designation;
	String JobDesc;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    Date lastDatetoApply;
    int CTC;
    String JobLocation;
    String companyName;
    String skills;
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getJobDesc() {
		return JobDesc;
	}
	public void setJobDesc(String jobDesc) {
		JobDesc = jobDesc;
	}
	public Date getLastDatetoApply() {
		return lastDatetoApply;
	}
	public void setLastDatetoApply(Date lastDatetoApply) {
		this.lastDatetoApply = lastDatetoApply;
	}
	public int getCTC() {
		return CTC;
	}
	public void setCTC(int cTC) {
		CTC = cTC;
	}
	public String getJobLocation() {
		return JobLocation;
	}
	public void setJobLocation(String jobLocation) {
		JobLocation = jobLocation;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	

}
