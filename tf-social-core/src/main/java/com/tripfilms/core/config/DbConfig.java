package com.tripfilms.core.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jolbox.bonecp.BoneCPDataSource;
@EnableTransactionManagement
@EnableJpaRepositories("com.tripfilms.core.dao")
@Configuration
public class DbConfig {

	    @Bean
	    public BoneCPDataSource boneCPDataSource() {

	        BoneCPDataSource oBoneCPDataSource = new BoneCPDataSource();
	        oBoneCPDataSource.setDriverClass("com.mysql.jdbc.Driver");
	        oBoneCPDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
	        oBoneCPDataSource.setUsername("root");
	        oBoneCPDataSource.setPassword("root");
	        oBoneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
	        oBoneCPDataSource.setIdleMaxAgeInMinutes(420);
	        oBoneCPDataSource.setMaxConnectionsPerPartition(30);
	        oBoneCPDataSource.setMinConnectionsPerPartition(10);
	        oBoneCPDataSource.setPartitionCount(3);
	        oBoneCPDataSource.setAcquireIncrement(5);
	        oBoneCPDataSource.setStatementsCacheSize(100);
	        oBoneCPDataSource.setReleaseHelperThreads(3);

	        return oBoneCPDataSource;

	    }

	    @Bean
	    public HibernateExceptionTranslator hibernateExceptionTranslator() {
	        return new HibernateExceptionTranslator();
	    }

	    @Bean
	    @Autowired
	    public EntityManagerFactory entityManagerFactory(BoneCPDataSource pDataSource) {
	        HibernateJpaVendorAdapter oVendorAdapter = new HibernateJpaVendorAdapter();
	        oVendorAdapter.setGenerateDdl(true);
	        oVendorAdapter.setShowSql(false);
	        oVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
	        oVendorAdapter.setDatabase(Database.MYSQL);

	        LocalContainerEntityManagerFactoryBean oFactory = new LocalContainerEntityManagerFactoryBean();
	        oFactory.setJpaVendorAdapter(oVendorAdapter);
	        oFactory.setPackagesToScan("com.tripfilms.core.be");
	        oFactory.setDataSource(pDataSource);

	        Properties oProperties = new Properties();
	        oProperties.setProperty("hibernate.cache.use_second_level_cache", "true");
	        oProperties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
	        oProperties.setProperty("hibernate.cache.use_query_cache", "true");
	        oProperties.setProperty("hibernate.generate_statistics", "true");

	        oFactory.setJpaProperties(oProperties);
	        oFactory.afterPropertiesSet();

	        return oFactory.getObject();
	    }

	    @Bean
	    @Autowired
	    public JpaTransactionManager transactionManager(EntityManagerFactory pEntityManagerFactory) {
	        JpaTransactionManager oTxManager = new JpaTransactionManager();
	        JpaDialect oJpaDialect = new HibernateJpaDialect();
	        oTxManager.setEntityManagerFactory(pEntityManagerFactory);
	        oTxManager.setJpaDialect(oJpaDialect);
	        return oTxManager;
	    }

	}
