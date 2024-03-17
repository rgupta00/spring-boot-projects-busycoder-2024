package com.employeeapp.config;

import com.employeeapp.controller.EmployeeController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig extends ResourceConfig {
    public RestConfig() {
        packages("com.employeeapp");
    }

    public RestConfig(Class<?>... classes) {
        register(EmployeeController.class);
    }
}

