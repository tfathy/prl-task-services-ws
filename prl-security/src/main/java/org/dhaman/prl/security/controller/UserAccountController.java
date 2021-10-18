package org.dhaman.prl.security.controller;

import org.dhaman.prl.security.model.CreateUserRequestModel;
import org.dhaman.prl.security.model.CreateUserResponseModel;
import org.dhaman.prl.security.model.UserResponseModel;
import org.dhaman.prl.security.service.SmmUsersService;
import org.dhaman.prl.security.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserAccountController {

	@Autowired
	private Environment env;

	@Autowired
	private SmmUsersService userAccountServices;

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		UserDto createdUser = userAccountServices.createUser(userDto);
		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

	@GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId) {

		UserDto userDto = userAccountServices.getUserByUserId(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);

		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
}
