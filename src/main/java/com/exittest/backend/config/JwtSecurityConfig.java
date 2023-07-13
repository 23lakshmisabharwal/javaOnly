package com.exittest.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exittest.backend.service.CustomUserDetailService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Configuration
/**
 * @author aryanverma
 * Configuration class for security settings.
 */
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private JwtAuthenticationEntryPoint unauthroizedHandler;
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtAuthenticationFilter JwtAuthenticationFilter;
	/**
	 * Configures the authentication manager builder with the custom user details
	 * service and password encoder.
	 *
	 * @param auth The authentication manager builder.
	 * @throws Exception If an exception occurs during the configuration process.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	}
	/**
	 * Creates a BCrypt password encoder bean.
	 *
	 * @return The BCrypt password encoder bean.
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	

	/**
	 * Configures the HTTP security settings.
	 *
	 * @param http The HTTP security object to configure.
	 * @throws Exception If an exception occurs during the configuration process.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http	
		.csrf().disable()
		.cors().disable()
		.authorizeRequests()
		.antMatchers("/api/generate-token","/api/user","/api/register").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthroizedHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
		http.addFilterBefore(JwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	/**
	 * Creates an authentication manager bean.
	 *
	 * @return The authentication manager bean.
	 * @throws Exception If an exception occurs while creating the bean.
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	
	
}
