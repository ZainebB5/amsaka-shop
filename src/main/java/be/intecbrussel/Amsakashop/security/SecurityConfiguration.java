package be.intecbrussel.Amsakashop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/","/products","/register").permitAll()
                .antMatchers(HttpMethod.GET,"/test").authenticated()
                .antMatchers(HttpMethod.GET,"/admin/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/","/products","/register").permitAll()
                .antMatchers(HttpMethod.POST,"/test").authenticated()
                .antMatchers(HttpMethod.POST,"/admin/**").hasAnyRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and().formLogin().loginPage("/login").permitAll()
                .failureUrl("/login?error = true")
                .defaultSuccessUrl("/")
                .usernameParameter("mail")
                .passwordParameter("password").defaultSuccessUrl("/",true).failureUrl("/login?error = true")
                .permitAll()
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().exceptionHandling()
                /*.and().csrf().disable()*/
                .and()
                .csrf()
                .disable()
                .headers().frameOptions().disable();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");}
}
