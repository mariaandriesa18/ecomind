package ro.utcn.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ro.utcn.project.service.UserService;

/**
 * This class is used to provide security to the endpoints.
 * Controllers can also provide security  at each endpoint
 * (Please check the annotations @HasRole and @HasAnyRoles).
 */
@Configuration
@EnableWebMvc
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers(
                "/register",
                "/home",
                "/admin",
                "/articles",
                "/household_profile",
                "/**"
                ).permitAll()
                .and().formLogin().defaultSuccessUrl("/", true) .loginPage("/login")
                .failureUrl("/login?error=true").permitAll()
                .and().logout().permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and().authorizeRequests()
                .anyRequest().authenticated();
        /**
         * Comment the above part and enable this one to disable security.
         * It is easier for development and testing.
         */
        //  http.authorizeRequests().anyRequest().permitAll();
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
