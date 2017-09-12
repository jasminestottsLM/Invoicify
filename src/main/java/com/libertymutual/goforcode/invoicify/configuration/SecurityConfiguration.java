package com.libertymutual.goforcode.invoicify.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/css/**", "/js/**").permitAll()
				.antMatchers("/invoices/**").hasAnyRole("ADMIN", "ACCOUNTANT")
				.antMatchers("/billing-records/**").hasAnyRole("ADMIN", "CLERK")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User
				.withUsername("admin")
				.password("admin")
				.roles("ADMIN")
				.build());

		manager.createUser(User
				.withUsername("clerk")
				.password("clerk")
				.roles("CLERK")
				.build());

		manager.createUser(User
				.withUsername("accountant")
				.password("accountant")
				.roles("ACCOUNTANT")
				.build());

		return manager;
	}
}
