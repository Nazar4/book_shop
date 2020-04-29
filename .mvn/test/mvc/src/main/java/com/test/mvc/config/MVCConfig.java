package com.test.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan(basePackages = { "com.test.mvc" })
public class MVCConfig extends WebMvcConfigurerAdapter implements SchedulingConfigurer {

    public void configureTasks(final ScheduledTaskRegistrar paramScheduledTaskRegistrar) {
        
    }

}
