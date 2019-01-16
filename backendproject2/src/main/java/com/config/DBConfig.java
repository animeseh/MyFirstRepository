package com.config;

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

import com.daos.BlogDao;
import com.daosimpl.BlogDaoImpl;
import com.models.ApplyJob;
import com.models.Blog;
import com.models.BlogComment;
import com.models.Forum;
import com.models.Friend;
import com.models.Job;
import com.models.ProfilePicture;
import com.models.User;


@Configuration
@ComponentScan({"com.daosimpl","com.models"})
@EnableTransactionManagement
public class DBConfig {

	@Bean(name="dataSource")
	public DataSource getDataSource(){
		System.out.println("About to create DataSource");
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("user_127");
		dataSource.setPassword("127");
		System.out.println("Data source created");
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(){
		System.out.println("About to create SessionFactory");
		Properties p=new Properties();
		p.setProperty("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		p.setProperty("hibernate.show_sql", "true");
		p.setProperty("hibernate.hbm2ddl.auto","update");
		
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getDataSource());
		factory.addAnnotatedClass(Blog.class);
		factory.addAnnotatedClass(User.class);
		factory.addAnnotatedClass(ApplyJob.class);
		factory.addAnnotatedClass(BlogComment.class);
		factory.addAnnotatedClass(Job.class);
		factory.addAnnotatedClass(Forum.class);
		factory.addAnnotatedClass(ProfilePicture.class);
		factory.addAnnotatedClass(Friend.class);
		factory.addProperties(p);
		
		System.out.println("SessionFactory created");
		return factory.buildSessionFactory();
	}
	
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		System.out.println("About to create Hibernate transaction manager");
		HibernateTransactionManager tx=new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction manager created");
		return tx;
	}
	

}

	 
	

