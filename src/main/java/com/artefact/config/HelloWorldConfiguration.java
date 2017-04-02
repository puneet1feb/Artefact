package com.artefact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.artefact.dao.ProductDAO;
import com.artefact.dao.ProductJDBCTemplate;
import com.artefact.service.ArtefactServices;
import com.artefact.service.ArtefactServicesImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.artefact")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter{
     
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxInMemorySize(1048576);
        resolver.setMaxUploadSize(20971520);
        return resolver;
    }
    
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://puneet-db-instance.czxus8zuwf32.us-west-2.rds.amazonaws.com:3306/artefact_lights");
        dataSource.setUsername("puneet1feb");
        dataSource.setPassword("site086cure523");
         
        return dataSource;
    }
     
    @Bean
    public ProductDAO getProductDAO() {
        return new ProductJDBCTemplate(getDataSource());
    }
    
    @Bean
    public ArtefactServices getArtefactServices() {
        return new ArtefactServicesImpl();
    }
 
}
