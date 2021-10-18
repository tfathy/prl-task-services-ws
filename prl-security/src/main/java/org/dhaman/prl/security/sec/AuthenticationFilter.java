package org.dhaman.prl.security.sec;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dhaman.prl.security.model.LoginRequestModel;
import org.dhaman.prl.security.service.SmmUsersService;
import org.dhaman.prl.security.shared.UserDto;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private SmmUsersService userService;
	private Environment environment;
	
	
	
	public AuthenticationFilter(SmmUsersService userService, Environment environment,
			AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.environment = environment;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			System.out.println(">>>>>>>>>>>>>>>>>>>>  attemptAuthentication is called");
			LoginRequestModel creds = new ObjectMapper().readValue(request.getInputStream(), LoginRequestModel.class);
			System.out.println(
					">>>>>> LoginRequestModel creds " + creds);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(),
					creds.getPassword(), new ArrayList<>()));

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// this method is automatically called by spring framework after successfully
		// log in
		// in this method we will use the user details objected to generate JWT
		String userName = ((User) authResult.getPrincipal()).getUsername();
		UserDto userDetails = userService.getUserDetailsByEmail(userName);

		String token = Jwts.builder().setSubject(userDetails.getUserId())
				.setExpiration(new Date(
						System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time"))))
				.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret")).compact();

		response.addHeader("TOKEN", token);
		response.addHeader("USER_ID", String.valueOf(userDetails.getUserId()));
		response.addHeader("LOGIN_NAME", String.valueOf(userDetails.getLoginName()));
		response.addHeader("DEFAULT_ROLE",String.valueOf( userDetails.getDefaultRole()));
		if (userDetails.getEmployee() != null) {		
			response.addHeader("EMP_NUM", String.valueOf(userDetails.getEmployee().getEmpNum()));
			response.addHeader("AR_NAME_FULL", userDetails.getEmployee().getArNameFull());
			response.addHeader("PHONE_EXT", String.valueOf(userDetails.getEmployee().getArNameFull()));
			response.addHeader("IAIGC_EMAIL", String.valueOf(userDetails.getEmployee().getIaigcEmail()));
			response.addHeader("ACTIVE", userDetails.getEmployee().getActive());			
			
		}	
	
	}

}
