package com.oa.taskmangementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


/*
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
*/
@SpringBootApplication //This annotation defines the Main class of a Spring Boot app
public class TaskmangementappApplication {

	public static void main(String[] args){
		SpringApplication.run(TaskmangementappApplication.class, args);
	}
}
