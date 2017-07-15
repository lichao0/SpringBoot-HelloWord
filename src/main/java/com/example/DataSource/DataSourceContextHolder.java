package com.example.DataSource;

public class DataSourceContextHolder {

	private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<DataSourceType>();

	public static void setDataSourceType(DataSourceType dsName) {
		contextHolder.set(dsName);
	}

	public static DataSourceType getDataSourceType() {
		return contextHolder.get();
	}
	
}
