package rebel.web.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;



@Configuration
@ComponentScan(basePackages ={"rebel.web"},excludeFilters = { @Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@EnableTransactionManagement
public class AppContextConfig
{
	@Bean(name="dataSource")
public DataSource getH2DataSource()
{
	
	System.out.println("get H2 data source");
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("prabhas");
	dataSource.setPassword("prabhas");
	
	return dataSource;
	
}

@Autowired
@Bean
public LocalSessionFactoryBean getSessionFactory(DataSource dataSource)
{
	
	System.out.println("local session factory ");
	LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
	sessionFactory.setDataSource(dataSource);
	sessionFactory.setHibernateProperties(getHibernateProperties());
	sessionFactory.setPackagesToScan(new String[] {"rebel.web.model"});
	
	return sessionFactory;
}


public Properties getHibernateProperties()
{
	
	System.out.println("get hibernate properties");
	Properties properties=new Properties();
	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	properties.setProperty("hibernate.show_sql", "true");
	properties.setProperty("hibernate.hbm2ddl.auto", "update");
	
	
	return properties;
}



@Autowired
@Bean
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println("hibernate transaction mgr"+sessionFactory);
	HibernateTransactionManager transactionManager=new HibernateTransactionManager();
	transactionManager.setSessionFactory(sessionFactory);
	
	return transactionManager;
}


}
