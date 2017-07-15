package com.example.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/** 
 * @项目名称：HelloWorld
 * @类名称：DatasourceConfiguration
 * @类描述：C3P0连接池配置
 * @创建人：Administrator
 * @创建时间：2017年3月27日 下午4:51:47
 * @company:步步高教育电子有限公司
 */
//@Configuration
public class DatasourceConfiguration {

//    @Bean(name = "dataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "c3p0")
//    public DataSource dataSource()
//    {
//    	return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
//    }
    
}