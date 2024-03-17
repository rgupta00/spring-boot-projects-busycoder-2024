package com.busycoder.employeeapp.emp.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.emp")
public class EmpDbProp {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
