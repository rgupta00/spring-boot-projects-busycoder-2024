package com.busycoder.employeeapp.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.busycoder.employeeapp.repo",
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBean",
        transactionManagerRef = "transactionManager"
)
public class AppConfig {

    @Autowired
    private DbProp dbProp;

    //i need to define datasouce
    @Bean
    public DriverManagerDataSource driverManagerDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUsername(dbProp.getUsername());
        dataSource.setPassword(dbProp.getPassword());
        dataSource.setDriverClassName(dbProp.getDriverClassName());
        dataSource.setUrl(dbProp.getUrl());
        return dataSource;
    }
    //transcation manager for jpa
    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean lcembf){
        EntityManagerFactory emf=lcembf.getObject();

        return new JpaTransactionManager(emf);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource){
        LocalContainerEntityManagerFactoryBean lcemfb
                =new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        lcemfb.setPackagesToScan(new String[]{"com.busycoder.employeeapp.entities"});
        lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties=new Properties();
        properties.put("hibernate.hbm2ddl.auto","validate");
        properties.put("hibernate.show-sql","true");

        lcemfb.setJpaProperties(properties);

        return lcemfb;
    }

    //entity manager factory

}
