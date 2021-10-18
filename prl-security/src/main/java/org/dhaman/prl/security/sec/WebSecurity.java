package org.dhaman.prl.security.sec;

import org.dhaman.prl.security.service.SmmUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	private Environment env;
	private SmmUsersService userService;
	private BCryptPasswordEncoder encoder;

	@Autowired
	public WebSecurity(Environment env, SmmUsersService userService, BCryptPasswordEncoder encoder) {
		this.env = env;
		this.userService = userService;
		this.encoder = encoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		// http.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip"))
		http.authorizeRequests().anyRequest().permitAll().and().addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
	}

	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, env, authenticationManager());
		authenticationFilter.setFilterProcessesUrl(env.getProperty("login.url.path"));
		return authenticationFilter;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(encoder);
	}

}
