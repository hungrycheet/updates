package com.example.TaskManagement.securityconfiguration;

import com.example.TaskManagement.service.UserInfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

         @Bean
         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http.csrf().disable()
                     .authorizeHttpRequests().antMatchers("/home","/saveuser").permitAll()
                     .and()
                     .authorizeHttpRequests().antMatchers("/task/*").authenticated()
                     .and()
                     .authorizeHttpRequests().antMatchers("/listtasks").authenticated()
                     .and().formLogin()
                     .and().logout()
                     .and().build();

         }

    @Bean
    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withUsername("sarath")
//                        .password(encoder.encode("password"))
//                        .roles("ADMIN")
//                        .build();
//        UserDetails user1 =
//                User.withUsername("vasu")
//                        .password(encoder.encode("password1"))
//                        .roles("USER")
//                        .build();

        return new UserInfoUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordencoder(){
             return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordencoder());

        return provider;

    }
}
