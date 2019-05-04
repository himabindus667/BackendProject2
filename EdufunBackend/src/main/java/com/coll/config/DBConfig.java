package com.coll.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.coll.model.Blog;
import com.coll.model.BlogComment;
import com.coll.model.Job;
import com.coll.model.UserRole;


@Configuration
@ComponentScan("com.coll")
@EnableTransactionManagement

public class DBConfig
{ 
	//1.DATASOURCE OBJECT
	
	@Bean
	public DataSource getDataSource()
	{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	
	dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("HIMABINDU");
	dataSource.setPassword("bindu1709");
	
	return dataSource;
	}

	
	//2. CREATE SESSION BEAN
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getDataSource());
        factory.addProperties(hibernateProp);
        factory.addAnnotatedClass(Blog.class);
        factory.addAnnotatedClass(BlogComment.class);
        factory.addAnnotatedClass(UserRole.class);
        factory.addAnnotatedClass(Job.class);
        
        
       
        

        
        System.out.println("---SessionFactory object created----");
        
        return factory.buildSessionFactory();
        		
	}
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
	System.out.println("----Transaction Object created----");
	return new HibernateTransactionManager(sessionFactory);
	}
}