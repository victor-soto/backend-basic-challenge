package com.victorsoto.athena.services;

import java.util.Collections;

import com.victorsoto.athena.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		var applicationUser = repository.findByUsername(username).orElseThrow(() -> {
			throw new UsernameNotFoundException(username);
		});

		return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.emptyList());
	}

}
