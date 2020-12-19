package com.victorsoto.athena.services;

import com.victorsoto.athena.entities.ApplicationUser;
import com.victorsoto.athena.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private final UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    ApplicationUser applicationUser = repository.findByUsername(username);
    if (applicationUser == null)
      throw new UsernameNotFoundException(username);

    return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.emptyList());
  }


}
