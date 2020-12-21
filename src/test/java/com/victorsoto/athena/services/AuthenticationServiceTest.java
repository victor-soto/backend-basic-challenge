package com.victorsoto.athena.services;

import java.util.Optional;

import com.victorsoto.athena.entities.ApplicationUser;
import com.victorsoto.athena.repositories.UserRepository;
import com.victorsoto.athena.viewmodels.ServiceResponse;
import com.victorsoto.athena.viewmodels.UserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AuthenticationServiceTest {

	@InjectMocks
	private AuthenticationService service;

	@Mock
	private UserRepository userRepository;

	@Mock
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@BeforeEach
	public void setUp() {
		service = new AuthenticationService(userRepository, bCryptPasswordEncoder);
	}

	@Test
	public void testSignUp_whenIsSuccessful() {
		var user = ApplicationUser.builder().id(1L).username("username").password("password").build();
		when(bCryptPasswordEncoder.encode(anyString())).thenReturn(user.getPassword());
		when(userRepository.save(any(ApplicationUser.class))).thenReturn(user);
		var request = UserRequest.builder().username(user.getUsername()).password(user.getPassword()).build();
		var testObserver = service.signUp(request).test();
		testObserver.awaitTerminalEvent();
		testObserver.assertComplete();
		var response = testObserver.values().stream().findFirst().orElse(new ServiceResponse());
		assertTrue(response.isSuccess());
	}
}