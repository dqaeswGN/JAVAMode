package com.ssm.chapter10.annotation.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.impl.RoleServiceImpl;
import com.ssm.chapter9.pojo.JuiceMaker2;
import com.ssm.chapter9.pojo.Source;

@ComponentScan(basePackageClasses = { Role.class, RoleServiceImpl.class }, 
excludeFilters = {@Filter(type = FilterType.REGEX, pattern="com.ssm.chapter10.annotation.config.AutowiredConfig")})
// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo",
// "com.ssm.chapter10.annotation.service"})
// @ComponentScan(basePackages = {"com.ssm.chapter10.annotation.pojo",
// "com.ssm.chapter10.annotation.service"},
// basePackageClasses = {Role.class, RoleServiceImpl.class})

//娴嬭瘯test8鐨勬椂鍊欏紩鍏ヤ笅闈㈢殑XML锛屽悓鏃舵敞閲婄幇鏈夋暟鎹簱杩炴帴姹犵殑鏂规硶
//@ImportResource({"classpath:spring-dataSource.xml"})
@PropertySource(value={"classpath:database-config.properties"}, ignoreResourceNotFound=true)
public class ApplicationConfig {
	
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/***
	 * 娴嬭瘯test8鐨勬椂鍊欓渶瑕佹敞閲婃帀鏁翠釜datasource锛屽惁鍒欎細鎶涘紓甯�
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		Properties props = new Properties();
		props.setProperty("driver", "com.mysql.jdbc.Driver");
		props.setProperty("url", "jdbc:mysql://localhost:3306/chapter10");
		props.setProperty("username", "root");
		props.setProperty("password", "123456");
		DataSource dataSource = null;
		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	
//	@Bean(name = "dataSource")
//	@Conditional({DataSourceCondition.class})
//	public DataSource getDataSource(
//			@Value("${jdbc.database.driver}") String driver,
//			@Value("${jdbc.database.url}") String url,
//			@Value("${jdbc.database.username}") String username, 
//			@Value("${jdbc.database.password}") String password) {
//		Properties props = new Properties();
//		props.setProperty("driver", driver);
//		props.setProperty("url", url);
//		props.setProperty("username", username);
//		props.setProperty("password", password);
//		DataSource dataSource = null;
//		try {
//			dataSource = BasicDataSourceFactory.createDataSource(props);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dataSource;
//	}
	
	@Bean(name="juiceMaker2", initMethod="init", destroyMethod="myDestroy")
	public JuiceMaker2 initJuiceMaker2() {
		JuiceMaker2 juiceMaker2 = new JuiceMaker2();
		juiceMaker2.setBeverageShop("璐¤尪");
		Source source = new Source();
		source.setFruit("姗欏瓙");
		source.setSize("澶ф澂");
		source.setSugar("灏戠硸");
	     juiceMaker2.setSource(source);
		return juiceMaker2;
	}
}