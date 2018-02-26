package com.example.demo;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@SpringBootApplication
@Configuration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/* @Bean
	    public DataSource dataSource(){
		 System.out.println("1");
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        System.out.println("2");
	        dataSource.setDriverClassName("com.mysql.jdbc.ReplicationDriver");
	        System.out.println("3");
	        dataSource.setUrl("jdbc:mysql:replication://192.168.252.194:3306,192.168.252.212:3306/medallion_db");
	        System.out.println("4");
	        dataSource.setUsername("root");
	        dataSource.setPassword("hsc123");
	        System.out.println(dataSource);
	        try {
				dataSource.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return dataSource;
	    }*/
}
