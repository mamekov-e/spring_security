package com.example.spring_security.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "com.example.spring_security")
@EnableWebMvc
public class SpringConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource =
                new ComboPooledDataSource();

        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/my_db?useSSL=false&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
