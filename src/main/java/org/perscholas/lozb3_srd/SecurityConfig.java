package org.perscholas.lozb3_srd;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO: Have the app only redirect to the login page for "/sheets" and "/profile"
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();

        // Anyone can access the following pages:
//        http
//                .authorizeRequests()
//                .antMatchers("/index", "/error", "/links", "/aboutus")
//                .permitAll();

    }
}
