package net.gb.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"net.gb.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	
	//Change below based on the DBMS you choose
	
	private final static String DATABASE_URL= "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER= "org.h2.Driver";
	private final static String DATABASE_DIALECT= "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME= "sa";
	private final static String DATABASE_PASSWORD= "";
	
	@Bean
	public DataSource getDataSource(){
		
		BasicDataSource datasource=new BasicDataSource();
		
		//Providing database connection information
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		
		
		return datasource;
	}
	
	//sessionFactory bean will be available
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.gb.shoppingbackend.dto");
		
		return 	builder.buildSessionFactory();
		
		
		
	}

	// All the hibernate properties will be return in this method
	
	private Properties getHibernateProperties() {
		
		Properties properties= new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		return properties;
	}
	//transactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory SessionFactory){
		
		HibernateTransactionManager transactionManager= new HibernateTransactionManager(SessionFactory);
		
		return transactionManager;
	}
	
}
