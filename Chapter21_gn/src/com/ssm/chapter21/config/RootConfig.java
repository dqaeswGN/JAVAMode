package com.ssm.chapter21.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@Configuration
//����Spring ɨ��İ�
@ComponentScan("com.*")
//ʹ����������������
@EnableTransactionManagement
//ʵ�ֽӿ�TransactionManagementConfigurer��������������ע����������
public class RootConfig implements TransactionManagementConfigurer {
	private DataSource dataSource = null;
	
	/**
	 * �������ݿ�����
	 */
	@Bean(name="datSource")
	public DataSource initDataSource(){
		if(dataSource != null){
			return dataSource;
		}
		Properties props=new Properties();
		props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		props.setProperty("url", "jdbc://mysql://192.168.152.131:3306/chpater13");
		props.setProperty("username", "guoning");
		props.setProperty("password", "guoning");
		try{
			dataSource = BasicDataSourceFactory.createDataSource(props);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean initSqlSessionFactory(){
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		//����mybatis�����ļ�
		Resource resource=new ClassPathResource("mybatis/mybatis-config.xml");
		sqlSessionFactory.setConfigLocation(resource);
		
		return sqlSessionFactory;
	}
	/**
	 * ͨ���Զ�ɨ�� ����mybatis mapper�ӿ�
	 * @return
	 */
	@Bean
	public MapperScannerConfigurer initMapperSacnnerConfigurer(){
		MapperScannerConfigurer msc = new MapperScannerConfigurer();
		// ɨ���
		msc.setBasePackage("com.*");
		msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
		// ����ע��ɨ��
		msc.setAnnotationClass(Repository.class);
		return msc;
	}
	/**
	 * ʵ�ֽӿڷ�����ע��ע�����񣬵�@Transactional ʹ�õ�ʱ��������ݿ�����
	 */
	@Override
	@Bean(name = "annotationDrivenTransactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(initDataSource());
		return transactionManager;
	}

}