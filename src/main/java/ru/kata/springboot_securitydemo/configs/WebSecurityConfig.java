package ru.kata.springboot_securitydemo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import ru.kata.springboot_securitydemo.service.UserDetailsServiceImp;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SuccessUserHandler successUserHandler;
    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;
    @Autowired
    private PasswordConfig passwordConfig;




    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().successHandler(successUserHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    // аутентификация inMemory
/*    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("{bcrypt}$2a$12$FmEDyUl/i4v30CwO3XJr1OLXFDgrqMJZg7Hcc.fyLPwcqC5J.269m") //user
                        .roles("USER")
                        .build();
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("{bcrypt}$2a$12$K/19g.4EART79omznyECPeWKU0DkdCCVg0Fg7tGOr7BZ4tOrYqdpy") //admin
                        .roles("USER", "ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }*/

    // 2 способ
    // jdbcAuthentication
    /*public JdbcUserDetailsManager users (DataSource dataSource) {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("{bcrypt}$2a$12$FmEDyUl/i4v30CwO3XJr1OLXFDgrqMJZg7Hcc.fyLPwcqC5J.269m") //user
                        .roles("USER")
                        .build();
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("{bcrypt}$2a$12$K/19g.4EART79omznyECPeWKU0DkdCCVg0Fg7tGOr7BZ4tOrYqdpy") //admin
                        .roles("USER", "ADMIN")
                        .build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        if (jdbcUserDetailsManager.userExists(user.getUsername())){
            jdbcUserDetailsManager.deleteUser(user.getUsername());
        }
        if (jdbcUserDetailsManager.userExists(admin.getUsername())){
            jdbcUserDetailsManager.deleteUser(admin.getUsername());
        }
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }*/



    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImp);
        daoAuthenticationProvider.setPasswordEncoder(passwordConfig.passwordEncoder());
        return daoAuthenticationProvider;
    }
}