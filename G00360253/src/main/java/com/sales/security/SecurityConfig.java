package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
 @Override
 protected void configure(HttpSecurity http) throws Exception {
  http
    .authorizeRequests()
    .antMatchers("/", "/index.html", "/ListProducts.html", "/ListOrders.html", "/ListCustomers.html", "/addProduct.html", "/newOrder.html", "/addCustomer.html")
    .authenticated()
    .and()
    .formLogin()
    .and()
    .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
	  auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
  }
}