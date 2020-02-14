package com.student.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan(basePackages = { "com.student"})
public class AppConfig {
	 
	 @Bean
	 public DataSource h2TestDataSource(){
	    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	 }
	 
	 @Bean
	   public JdbcTemplate jdbcTemplate() {
		 JdbcTemplate source = new JdbcTemplate();
	      source.setDataSource(h2TestDataSource());
	      return source;
	   }
	 
	
}
