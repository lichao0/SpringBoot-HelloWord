package com.example.DataSource;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.loading.ClassLoaderRepository;
import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@Configuration
@AutoConfigureAfter({ DataSourceConfiguration.class })
@MapperScan("com.example.dao")
public class MybatisConfiguration extends MybatisAutoConfiguration  {
	
	final static Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);
	
	@Autowired
    private Environment env;
	
	@Resource(name = "dataSource1")
	private DataSource dataSource1;
	@Resource(name = "dataSource2")
	private DataSource dataSource2;

//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(DynamicDataSource dataSource) throws Exception {
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        
//        logger.info("................init sqlSessionFactory.......................");
//        
//        fb.setDataSource(dataSource);// 指定数据源(这个必须有，否则报错)
//        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
//        fb.setTypeAliasesPackage("com.example");// 指定基包
//        fb.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources("com.example"));
//        return fb.getObject();
//    }
	

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
		logger.info("................init sqlSessionFactory.......................");
		return super.sqlSessionFactory(dataSource);
	}

	@Bean(name = "dataSource")
	public DynamicDataSource dynamicDataSource() {
		logger.info("................init roundRobinDataSouceProxy.......................");
		
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		Map<Object, Object> targetDataResources = new HashMap<Object, Object>();
		targetDataResources.put(DataSourceType.dataSource1, dataSource1);
		targetDataResources.put(DataSourceType.dataSource2, dataSource2);
		dynamicDataSource.setDefaultTargetDataSource(dataSource1);// 默认源
		dynamicDataSource.setTargetDataSources(targetDataResources);
		return dynamicDataSource;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		logger.info("................init sqlSessionTemplate.......................");
		return super.sqlSessionTemplate(sqlSessionFactory);
	}
    
	@Bean
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DynamicDataSource dataSource)
			throws Exception {
		logger.info("................init transactionManager.......................");
		return new DataSourceTransactionManager(dataSource);
	}

}
