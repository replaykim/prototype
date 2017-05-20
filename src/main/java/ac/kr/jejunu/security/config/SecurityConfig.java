package ac.kr.jejunu.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Boobby on 17-5-15.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/stylesheets/**", "/javascripts/**", "/");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .loginProcessingUrl("/loginProcessing")
                .failureUrl("/login?error")
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
            .authorizeRequests()
                .antMatchers(
                        "/auth/**",
                        "/login",
                        "/error",
                        "/signup/**",
                        "/",
                        "/index",
                        "/register",
                        "/registerProcessing"
                ).permitAll()
                .anyRequest().authenticated();
    }

    @Configuration
    public static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter
    {
        @Autowired
        UserDetailsService userDetailsService;

        @Bean
        PasswordEncoder passwordEncoder()
        {
            return new BCryptPasswordEncoder();
        }

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception
        {
            auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        }
    }
}
