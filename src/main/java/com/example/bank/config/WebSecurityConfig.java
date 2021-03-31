package com.example.bank.config;

import com.example.bank.service.impl.DatabaseUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Configuration
    public static class MySecurityConfig extends WebSecurityConfigurerAdapter {


        @Autowired
        @Qualifier("databaseUserDetailsService")
        private DatabaseUserDetailsService userDetailsService;
        @Autowired
        private ValidateCodeFilter validateCodeFilter;

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers("/index/**").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/fonts/**").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers("/lib/**").permitAll()
                    .antMatchers("/scriipts/**").permitAll()
                    .antMatchers("/Scripts/**").permitAll()
                    .antMatchers("/Styles/**","/code/image").permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/adminLogin").loginProcessingUrl("/login")
                    .permitAll()
                    .and()
                    .headers()
                    .frameOptions()
                    .sameOrigin()
                    .and()
                    .csrf()
                    .disable();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }

        public static void main(String[] args) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = bCryptPasswordEncoder.encode("333".trim());
            System.out.println(encodedPassword);
        }
    }
}