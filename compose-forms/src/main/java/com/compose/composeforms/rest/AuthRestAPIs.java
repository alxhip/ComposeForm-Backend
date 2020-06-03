package com.compose.composeforms.rest;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compose.composeforms.entity.Role;
import com.compose.composeforms.entity.RoleName;
import com.compose.composeforms.entity.Users;
import com.compose.composeforms.message.request.LoginForm;
import com.compose.composeforms.message.request.SignUpForm;
import com.compose.composeforms.message.response.JwtResponse;
import com.compose.composeforms.repository.RoleRepository;
import com.compose.composeforms.repository.UserRepository;
import com.compose.composeforms.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@CrossOrigin("http://localhost:3000")
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
		System.out.println(loginRequest);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@CrossOrigin("http://localhost:3000")
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) throws Exception {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<String>("Username is already taken!", HttpStatus.BAD_REQUEST);
		}

		Users user = new Users(signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

		Set<Role> roles = new HashSet<>();

		roles.add(roleRepository.findByCode(RoleName.User)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find.")));
		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok().body("User registered successfully!");
	}
}