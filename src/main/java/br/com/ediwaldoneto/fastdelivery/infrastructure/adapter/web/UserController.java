package br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.domain.port.service.UserServicePort;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.mapper.UserMapper;
import br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.web.request.UserRequest;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserServicePort userServicePort;

	@Autowired
	public UserController(UserServicePort userServicePort) {
		this.userServicePort = userServicePort;
	}

	@PostMapping
	public ResponseEntity<User> registerUser(@RequestBody UserRequest dto) {
		User user = UserMapper.INSTANCE.toDomain(dto);
		userServicePort.registerUser(user);
		return ResponseEntity.ok().build();
	}

}
