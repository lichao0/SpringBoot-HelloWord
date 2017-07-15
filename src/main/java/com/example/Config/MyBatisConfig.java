package com.example.Config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * springboot集成mybatis的基本入口 1）创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2）创建SqlSessionFactory 3）配置事务管理器，除非需要使用事务，否则不用配置
 */
//@Configuration // 该注解类似于spring配置文件
//@MapperScan(basePackages = "com.example.mapper")
public class MyBatisConfig {

//    @Autowired
//    private Environment env;
//    
//    private Class<? extends DataSource> dataSourceType = com.alibaba.druid.pool.DruidDataSource.class;
//
//    /**
//     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
//     */
//    @Bean(name="dataSource1")
//    @ConfigurationProperties(prefix = "jdbc1")
//	public DataSource dataSource1() throws Exception {
//		return DataSourceBuilder.create().type(dataSourceType).build();
//	}
//
//    @Bean
//    @Qualifier("dataSource2")
//    public DataSource dataSource2() throws Exception {
//        Properties props = new Properties();
//        props.put("driverClassName", env.getProperty("jdbc2.driverClassName"));
//        props.put("url", env.getProperty("jdbc2.url"));
//        props.put("username", env.getProperty("jdbc2.username"));
//        props.put("password", env.getProperty("jdbc2.password"));
//        return DruidDataSourceFactory.createDataSource(props);
//    }
//
//    /**
//     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
//     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
//     */
//    @Bean
//    @Primary
//    public DynamicDataSource dataSource(@Qualifier("dataSource1") DataSource dataSource1,
//            @Qualifier("dataSource2") DataSource dataSource2) {
//        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
//        targetDataSources.put("dataSource1", dataSource1);
//        targetDataSources.put("dataSource2", dataSource2);
//
//        DynamicDataSource dataSource = new DynamicDataSource();
//        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
//        dataSource.setDefaultTargetDataSource(dataSource1);// 默认的datasource设置为dataSource1
//
//        return dataSource;
//    }
//
//    /**
//     * 根据数据源创建SqlSessionFactory
//     */
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
//        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
//        fb.setDataSource(ds);// 指定数据源(这个必须有，否则报错)
//        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
//        fb.setMapperLocations(
//                new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));//
//
//        return fb.getObject();
//    }
//
//    /**
//     * 配置事务管理器
//     */
//    @Bean
//    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
//        return new DataSourceTransactionManager(dataSource);
//    }

}


/**
 * 动态数据源（需要继承AbstractRoutingDataSource）
 */
//class DynamicDataSource extends AbstractRoutingDataSource {
//    protected Object determineCurrentLookupKey() {
//        return DatabaseContextHolder.getDatabaseType();
//    }
//}


/**
 * 列出所有的数据源key（常用数据库名称来命名）
 * 注意：
 * 1）这里数据源与数据库是一对一的
 * 2）DatabaseType中的变量名称就是数据库的名称
 */
//enum DatabaseType {
//	dataSource1, dataSource2
//}