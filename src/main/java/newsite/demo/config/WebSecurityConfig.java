package newsite.demo.config;


import newsite.demo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserServiceImpl service;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                  .csrf()
                  .disable()
                  .authorizeRequests()
                  .antMatchers("/registration").permitAll()
                  .antMatchers("/resources/**").permitAll()
                  .anyRequest().authenticated()
                .and()
                  .formLogin()
                //.usernameParameter("login")
                  .passwordParameter("password")
                  .loginPage("/login")
                  .defaultSuccessUrl("/")
                  .failureUrl("/login?error")
                  .permitAll()
                .and()
                  .logout().permitAll()
                  .permitAll();


    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


}