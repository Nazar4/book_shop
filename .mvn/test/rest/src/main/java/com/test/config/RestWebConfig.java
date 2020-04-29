package com.test.config;

import org.springframework.core.annotation.Order;
import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.util.HttpSessionMutexListener;

import javax.servlet.*;

@Order(value = 1)
public class RestWebConfig implements WebApplicationInitializer {

    public void onStartup(final ServletContext servletContext) throws ServletException {

        final AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        webCtx.register(RestConfig.class);

        servletContext.addListener(new RequestContextListener());
        servletContext.addListener(new HttpSessionMutexListener());
        
        /* Spring REST Delegating Dispatcher Servlet */
        final Servlet restDispatcherServlet = new RepositoryRestDispatcherServlet(webCtx);
        final ServletRegistration.Dynamic restDispatcherServletReg = servletContext.addServlet("restDispatcherServlet", restDispatcherServlet);
        restDispatcherServletReg.setLoadOnStartup(1);
        restDispatcherServletReg.addMapping("/rest/*");
        
        /* Character Encoding Filter */
        final FilterRegistration charEncodingfilterReg = servletContext.addFilter("restCharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingfilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingfilterReg.setInitParameter("forceEncoding", "true");
        charEncodingfilterReg.addMappingForServletNames(null, false, restDispatcherServletReg.getName());
        
        /* Spring Security Delegating Filter */
        // FilterRegistration springSecurityFilterChainReg = servletContext.getFilterRegistration("springSecurityFilterChain");
        // springSecurityFilterChainReg.addMappingForServletNames(null, false, restDispatcherServletReg.getName());
    }
}
