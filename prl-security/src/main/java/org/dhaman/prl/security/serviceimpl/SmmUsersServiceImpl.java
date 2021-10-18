package org.dhaman.prl.security.serviceimpl;

import java.util.ArrayList;
import java.util.UUID;

import org.dhaman.prl.security.entity.SmmUsers;
import org.dhaman.prl.security.repos.SmmUsersRepos;
import org.dhaman.prl.security.service.SmmUsersService;
import org.dhaman.prl.security.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SmmUsersServiceImpl implements SmmUsersService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	BCryptPasswordEncoder encoder;
	SmmUsersRepos repos;

	@Autowired
	public SmmUsersServiceImpl(SmmUsersRepos repos, BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
		this.repos = repos;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		System.out.println(userDetails);
		System.out.println(userDetails.getUserPassword());
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptPw(encoder.encode(userDetails.getUserPassword()));

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		SmmUsers userEntity = modelMapper.map(userDetails, SmmUsers.class);

		repos.save(userEntity);

		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);

		return returnValue;
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		SmmUsers userEntity = repos.findByLoginName(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		return new ModelMapper().map(userEntity, UserDto.class);
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		SmmUsers userEntity = repos.findByUserId(userId);
		if (userEntity == null)
			throw new UsernameNotFoundException("User not found");

		UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
		return userDto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SmmUsers userEntity = repos.findByLoginName(username);

		if (userEntity == null)
			throw new UsernameNotFoundException(username);
		System.out.println(">>> returned user in loadUserByUsername *******************************");
		System.out.println(userEntity.getLoginName());

		System.out.println("*************************************************************************");

		return new User(userEntity.getLoginName(), userEntity.getEncryptPw(), true, true, true, true,
				new ArrayList<>());
	}

}
