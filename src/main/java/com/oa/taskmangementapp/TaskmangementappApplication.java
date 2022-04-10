package com.oa.taskmangementapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
*/
@SpringBootApplication //This annotation defines the Main class of a Spring Boot app
public class TaskmangementappApplication{
	public static void main(String[] args){

		SpringApplication.run(TaskmangementappApplication.class, args);
	}
}
