package com.omeraran.account.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/v1/customer/**").hasRole("USER")
                    .antMatchers(HttpMethod.POST, "/v1/account/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();

    }
}
