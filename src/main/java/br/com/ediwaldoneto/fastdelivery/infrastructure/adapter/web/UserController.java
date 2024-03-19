package br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.domain.port.service.UserServicePort;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.mapper.UserMapper;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.request.UserRequest;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.response.UserResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserServicePort userServicePort;

	@Autowired
	public UserController(UserServicePort userServicePort) {
		this.userServicePort = userServicePort;
	}

	@PostMapping
	public ResponseEntity<String> registerUser(@RequestBody UserRequest dto) {
		User user = UserMapper.INSTANCE.toDomain(dto);
		userServicePort.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("user created successfully.");
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
		User user = userServicePort.getUser(id);
		return ResponseEntity.ok().body(UserMapper.INSTANCE.toResponse(user));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest dto) {
		User user = userServicePort.updateUser(id, UserMapper.INSTANCE.toDomain(dto));
		return ResponseEntity.ok().body(UserMapper.INSTANCE.toResponse(user));
	}

}
