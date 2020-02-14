package com.student.main;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "com.student"})
public class AppConfig {
	 
	
	 
	 public DataSource dataSource() {
	      DriverManagerDataSource ds = new DriverManagerDataSource();
	      ds.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
	      ds.setUrl("jdbc:mysql://localhost:3306/giffgaff");
	      ds.setUsername("root");
	      ds.setPassword("root");
	      return ds;
	  }
	 
	
	 
	 @Bean
	   public JdbcTemplate jdbcTemplate() {
		 JdbcTemplate source = new JdbcTemplate();
	      source.setDataSource(dataSource());
	      return source;
	   }
	 
	
	 
	
}
