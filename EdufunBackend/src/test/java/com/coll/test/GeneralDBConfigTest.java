package com.coll.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GeneralDBConfigTest {

	public static void main(String[] args) 
	{
    AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
   
    context.scan("com.coll");
   
    context.refresh();
	}

}

