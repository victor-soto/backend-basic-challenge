package com.victorsoto.athena.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.victorsoto.athena.services.IAuthenticationService;
import com.victorsoto.athena.viewmodels.ServiceResponse;
import com.victorsoto.athena.viewmodels.UserRequest;
import io.reactivex.Single;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsersControllerTest {

  @Autowired
  WebApplicationContext applicationContext;

  @MockBean
  IAuthenticationService authenticationService;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    initMocks(this);
    mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
  }

  @Test
  public void signUp_successfully() throws Exception {
    when(authenticationService.signUp(any(UserRequest.class))).thenReturn(Single.just(new ServiceResponse(true, Collections.emptyList())));

    var mvcResult = mockMvc.perform(post("/users/sign-up").contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(UserRequest.builder().username("username").password("secret").build())))
        .andExpect(status().isOk()).andReturn();

    mockMvc.perform(asyncDispatch(mvcResult)).andExpect(jsonPath("$.success", is(true)));

    verify(authenticationService, times(1)).signUp(any(UserRequest.class));
  }
}