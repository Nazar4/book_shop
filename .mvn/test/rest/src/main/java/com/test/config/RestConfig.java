package com.test.config;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

@EnableWebMvc
@Configuration
@EnableJpaRepositories(basePackages = { "com.test" })
@ComponentScan(basePackages = { "com.test" }, includeFilters = @Filter({ Controller.class, Component.class, Service.class }), useDefaultFilters = false)
public class RestConfig extends RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {
        try {
            config.setBaseUri(new URI("/rest"));
        } catch (final BeansException e) {
            e.printStackTrace();
        } catch (final URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
    @Bean(name = { "defaultEntityManagerFactory", "entityManagerFactory" })
    protected LocalContainerEntityManagerFactoryBean defaultEntityManagerFactory() throws PropertyVetoException, IOException {
        final LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(defaultDataSource());
        entityManagerFactory.setJpaVendorAdapter(defaultJpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("com.nemesis.platform.core.model", "com.nemesis.platform.modules.model");
        entityManagerFactory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        entityManagerFactory.setJpaProperties(defaultJpaProperties());

        return entityManagerFactory;
    }
    
    @Bean(name = { "defaultDataSource", "dataSource" })
    public DataSource defaultDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.HSQL).build();
    }
    
    @Bean(name = { "defaultJpaVendorAdapter", "jpaVendorAdapter" })
    protected JpaVendorAdapter defaultJpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(false);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.HSQL);

        return hibernateJpaVendorAdapter;
    }

    @Bean(name = { "defaultJpaProperties", "jpaProperties" })
    protected Properties defaultJpaProperties() throws IOException {
        final Properties jpaProperties = new Properties();
        jpaProperties.put("javax.persistence.sharedCache.mode", "ENABLE_SELECTIVE");
        jpaProperties.put("hibernate.archive.autodetection", "class");
        jpaProperties.put("hibernate.show_sql", false);
        jpaProperties.put("hibernate.format_sql", true);
        jpaProperties.put("hibernate.use_sql_comments", true);

        return jpaProperties;
    }
}
