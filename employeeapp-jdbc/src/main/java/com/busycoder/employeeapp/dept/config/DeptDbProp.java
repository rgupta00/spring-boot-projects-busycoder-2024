package com.busycoder.employeeapp.dept.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Primary
@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.dept")
public class DeptDbProp {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
