package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Created by WangXinbiao on 2019/02/12
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthenticationProvider provider;  //注入我们自己的AuthenticationProvider

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        //super.configure(http);
        http
            .formLogin().loginPage("/login").loginProcessingUrl("/login/form").failureUrl("/login-error").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
            .and()
            .authorizeRequests()
            .antMatchers("/public/**").permitAll()
            .antMatchers("/oauth/*").permitAll()
            .antMatchers("/about/**").hasRole("p1")
//            .antMatchers("/about/**").hasAuthority("ZHANGSAN")
            .anyRequest().authenticated()
            .and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

//        auth
//                .inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER")
//                .and()
//                .withUser("test").password("test123").roles("ADMIN");
        auth.authenticationProvider(provider);
    }
//@Bean
//@Override
//protected UserDetailsService userDetailsService(){
//    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//    manager.createUser(User.withUsername("user_1").password("123456").authorities("USER").build());
//    manager.createUser(User.withUsername("user_2").password("123456").authorities("USER").build());
//    return manager;
//}
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // @formatter:off
//        http
////                .requestMatchers().anyRequest()
////                .and()
//            .authorizeRequests()
//            .antMatchers("/oauth/**").permitAll()
//            .anyRequest().authenticated()
//            .and()
//            .csrf().disable();
//        // @formatter:on
//    }
}
