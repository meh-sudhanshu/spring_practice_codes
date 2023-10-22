//package com.codelantern.userservice.configs;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class InMemoryUserManager {
//
//
////    String queryToFetchUsers = "select username, password from user where username = *";
////    String queryToFetchAuthorities= "";
////
////
////    @Bean
////    public PasswordEncoder passwordEncoder(){
////        return new
////                BCryptPasswordEncoder();
////    }
////
////
////    @Bean
////    public UserDetailsManager userDetailsManager(DataSource dataSource){
////        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
////        jdbcUserDetailsManager.setDataSource(dataSource);
////        jdbcUserDetailsManager.setUsersByUsernameQuery(queryToFetchUsers);
////        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(queryToFetchAuthorities);
////
////        return  jdbcUserDetailsManager;
////    }
//
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//        UserDetails user = User.builder()
//                .username("user1")
//                .password("{noop}user@123")
//                .roles("USER")
//                .build();
//
//        UserDetails user2 = User.builder()
//                .username("user2")
//                .password("{noop}user@123")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user2,user);
//    }
//}
