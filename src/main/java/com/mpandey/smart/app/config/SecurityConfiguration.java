/**
 * 
 */
package com.mpandey.smart.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author Madhav Pandey
 * @date Sep 3, 2017
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	@Qualifier("userService")
	UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("madhav_pandey").password("test").roles("ADMIN").and()
		.withUser("demo").password("test").roles("DEMO");
	}*/

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
			.userDetailsService(userDetailsService)
		//auth.pass(authenticationProvider());
			.passwordEncoder(passwordEncoder);
	}

	/*@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}*/

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		http.
			authorizeRequests()
				.antMatchers("/**/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/admin/registration").permitAll().and().csrf().disable()
				.formLogin()
					.loginPage("/login").failureUrl("/login?error=true")
					.defaultSuccessUrl("/admin/home")
					.usernameParameter("email")
					.passwordParameter("password")
					.and().logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/").and().exceptionHandling()
					.accessDeniedPage("/access-denied");
				/*//.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
				//.authenticated().and().csrf().disable().formLogin()
				.loginPage("/login").failureUrl("/login?error=true")
				.defaultSuccessUrl("/admin/home")
				.usernameParameter("email")
				.passwordParameter("password")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/access-denied");*/
		//http.csrf().disable();
	}
}
