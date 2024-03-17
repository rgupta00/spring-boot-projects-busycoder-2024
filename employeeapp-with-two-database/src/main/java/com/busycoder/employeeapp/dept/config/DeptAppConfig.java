package com.busycoder.employeeapp.dept.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = "com.busycoder.employeeapp.dept.repo",
        entityManagerFactoryRef = "emf2",
        transactionManagerRef = "tx2"
)
public class DeptAppConfig {

    @Autowired
    private DeptDbProp dbProp;

    //i need to define datasouce
    @Bean
    @Primary
    public DriverManagerDataSource ds2(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUsername(dbProp.getUsername());
        dataSource.setPassword(dbProp.getPassword());
        dataSource.setDriverClassName(dbProp.getDriverClassName());
        dataSource.setUrl(dbProp.getUrl());
        return dataSource;
    }
    //transcation manager for jpa
    @Primary
    @Bean
    public PlatformTransactionManager tx2(){
        EntityManagerFactory emf= emf2().getObject();

        return new JpaTransactionManager(emf);
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean emf2(){
        LocalContainerEntityManagerFactoryBean lcemfb
                =new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(ds2());
        lcemfb.setPackagesToScan(new String[]{"com.busycoder.employeeapp.dept.entities"});
        lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties properties=new Properties();
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.show-sql","true");

        lcemfb.setJpaProperties(properties);

        return lcemfb;
    }

}
