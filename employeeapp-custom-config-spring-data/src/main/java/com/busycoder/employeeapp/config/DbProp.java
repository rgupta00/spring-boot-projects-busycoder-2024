package com.busycoder.employeeapp.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DbProp {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}
