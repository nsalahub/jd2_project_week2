package com.gmail.salahub.nikolay.jd2_project_week2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
        "com.gmail.salahub.nikolay.jd2_project_week2.config",
        "com.gmail.salahub.nikolay.jd2_project_week2.controller",
        "com.gmail.salahub.nikolay.jd2_project_week2.service",
        "com.gmil.salahub.nikolay.jd2_project_week2.repository"
})
@PropertySource("classpath:jdbc.properties")
public class AppConfig {
}
