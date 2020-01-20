package com.spandiar.jpa.transaction.repository;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	
	@Value("${spring.datasource.primary.url}")
	private String URL;
	@Value("${spring.datasource.primary.username}")
	private String USERNAME;
	@Value("${spring.datasource.primary.password}")
	private String PASSWORD;
	@Value("${spring.jpa.hibernate.dialect}")
	private String DIALECT;
	
	@Bean
	public DataSource getPrimaryDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.url(URL);
		dataSourceBuilder.username(USERNAME);
		dataSourceBuilder.password(PASSWORD);
		dataSourceBuilder.driverClassName("org.postgresql.Driver");
		
		return dataSourceBuilder.build();
	};
	
	/*
	 * @Bean(name = "sqlSessionFactory") public SqlSessionFactory
	 * sqlSessionFactory() throws Exception { final SqlSessionFactoryBean
	 * sessionFactory = new SqlSessionFactoryBean();
	 * sessionFactory.setDataSource(getdataSource());
	 * //sessionFactory.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.
	 * NULL); return sessionFactory.getObject(); }
	 */
	
}
