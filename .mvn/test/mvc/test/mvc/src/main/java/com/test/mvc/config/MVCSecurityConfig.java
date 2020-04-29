package com.test.mvc.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class MVCSecurityConfig {

    @Resource
    public ApplicationContext context;
    
    @Order(1)
    @Configuration
    public static class CheckoutStorefrontSecurityConfig extends WebSecurityConfigurerAdapter {
        
    }
    
    @Order(2)
    @Configuration
    public static class DefaultStorefrontSecurityConfig extends WebSecurityConfigurerAdapter {
        
    }
    
    @Bean(name = {"defaultAuthenticationManager", "authenticationManager"})
    public AuthenticationManager defaultAuthenticationManager() throws Exception {
        return new AuthenticationManagerBuilder(ObjectPostProcessor.QUIESCENT_POSTPROCESSOR).userDetailsService(context.getBean(TestUserDetailsService.class)).passwordEncoder(new Md5PasswordEncoder()).and().build();
    }
}
