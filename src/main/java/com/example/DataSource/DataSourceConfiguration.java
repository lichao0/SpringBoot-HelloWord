package com.example.DataSource;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {

	final static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

	@Value("${datasource.type}")
	private Class<? extends DataSource> dataSourceType;

	@Primary
	@Bean(name = "dataSource1")
	@ConfigurationProperties(prefix = "jdbc1")
	public DataSource dataSourceOne() {
		logger.info("-------------------- dataSource1 init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}
	
	@Bean(name = "dataSource2")
	@ConfigurationProperties(prefix = "jdbc2")
	public DataSource dataSourceTwo() {
		logger.info("-------------------- dataSource2 init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}

}
