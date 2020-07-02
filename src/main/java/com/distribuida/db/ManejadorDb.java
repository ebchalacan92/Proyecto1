package com.distribuida.db;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

@ApplicationScoped
public class ManejadorDb {
	
	@Produces @ApplicationScoped
	
	public DataSource db() {
		
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setUrl("jdbc:postgresql://127.0.0.1:5432/distribuida");
		ds.setUsername("postgres");
		ds.setPassword("admin");
		
		return ds ;
	}

}
