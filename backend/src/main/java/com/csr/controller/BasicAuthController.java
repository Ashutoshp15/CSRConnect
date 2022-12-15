package com.hotelbooking.controller;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.models.User;
import com.hotelbooking.models.request.LoginRequest;
import com.hotelbooking.models.request.SignUpRequest;
import com.hotelbooking.models.response.LoginResponse;
import com.hotelbooking.security.JwtUtil;
import com.hotelbooking.service.MyUserDetailsService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {


    private final JwtUtil jwtUtil;

    private final MyUserDetailsService myUserDetailsService;

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder bcryptEncoder;

    public BasicAuthController(
        final JwtUtil jwtUtil,
        final MyUserDetailsService myUserDetailsService,
        final AuthenticationManager authenticationManager,
        final PasswordEncoder bcryptEncoder) {
      this.jwtUtil = jwtUtil;
      this.myUserDetailsService = myUserDetailsService;
      this.authenticationManager = authenticationManager;
      this.bcryptEncoder = bcryptEncoder;
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody final LoginRequest loginRequest) throws Exception {
      try {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));
      } catch (EntityNotFoundException e) {
        throw new EntityNotFoundException("Incorrect Username or Password");
      }

      User loggedInUser = myUserDetailsService.getUserByUsername(loginRequest.getUsername()).get();

      final String jwt = jwtUtil.generateToken(loggedInUser);
      new LoginResponse(jwt);
      return loggedInUser.getOrgName();
    }

    @PostMapping("/signup")
    public LoginResponse register(@Valid @RequestBody final SignUpRequest signUpRequest)
        throws Exception {
      Optional<User> user = myUserDetailsService.getUserByUsername(signUpRequest.getUsername());
      if (user.isEmpty()) {
        myUserDetailsService.save(
            new User(
                signUpRequest.getUsername(),
                bcryptEncoder.encode(signUpRequest.getPassword()),
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail().toLowerCase(),
                signUpRequest.getRole(),
                signUpRequest.getOrgName()));
        User addedUser = myUserDetailsService.getUserByUsername(signUpRequest.getUsername()).get();
        final String jwt = jwtUtil.generateToken(addedUser);
        return new LoginResponse(jwt);
      } else {
        throw new EntityNotFoundException("Username already exists");
      }
    }

    @GetMapping("/users")
    public User getUserDetails() throws Exception {
      try {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return myUserDetailsService.getUserByUsername(username).get();
      } catch (Exception e) {
        throw new EntityNotFoundException("User not found");
      }
    }

}
