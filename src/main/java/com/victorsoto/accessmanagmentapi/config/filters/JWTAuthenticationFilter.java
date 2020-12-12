package com.victorsoto.accessmanagmentapi.config.filters;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.victorsoto.accessmanagmentapi.entities.ApplicationUser;
import com.victorsoto.accessmanagmentapi.viewmodels.BearerTokenResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.victorsoto.accessmanagmentapi.config.constants.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final AuthenticationManager authenticationManager;

  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
    setFilterProcessesUrl(SIGN_IN_URL);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    try {
      var credentials = new ObjectMapper()
          .readValue(request.getInputStream(), ApplicationUser.class);

      return authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              credentials.getUsername(),
              credentials.getPassword(),
              Collections.emptyList())
      );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                          Authentication authResult) throws IOException {
    String username = ((User) authResult.getPrincipal()).getUsername();
    var expiresAt = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
    var token = JWT.create()
        .withSubject(username)
        .withExpiresAt(expiresAt)
        .sign(HMAC512(SECRET.getBytes()));
    var bearerResponse = BearerTokenResponse.builder().bearerToken(token).expiration(expiresAt.getTime()).build();
    response.getWriter().write(new ObjectMapper().writeValueAsString(bearerResponse));
    response.addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE);
    response.getWriter().flush();
  }
}
