package com.project2.backendproject;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.DBConfig;



public class AppTest {
	
	@BeforeClass
	 public static void init(){
	        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	        context.register(DBConfig.class);
	        context.refresh();
	    }
	
	 @Test
	 @Ignore
	 public void test(){
         
	    }
	}






