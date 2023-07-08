package com.example.spring_security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("erik").password("erik").roles("EMPLOYEE"))
//                .withUser(userBuilder.username("hasan").password("hasan").roles("HR"))
//                .withUser(userBuilder.username("maksat").password("maksat").roles("HR", "MANAGER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr-info").hasRole("HR")
                .antMatchers("/manager-info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }
}
