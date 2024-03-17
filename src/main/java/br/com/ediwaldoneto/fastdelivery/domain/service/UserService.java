package br.com.ediwaldoneto.fastdelivery.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.domain.port.repository.UserRepositoryPort;
import br.com.ediwaldoneto.fastdelivery.domain.port.service.UserServicePort;

@Service
public class UserService implements UserServicePort {

	private final UserRepositoryPort userRepositoryPort;

	@Autowired
	public UserService(UserRepositoryPort userRepositoryPort) {
		this.userRepositoryPort = userRepositoryPort;
	}

	@Override
	public void registerUser(User user) {
		userRepositoryPort.save(user);

	}

	@Override
	public User getUser(Long id) {
		return userRepositoryPort.findById(id);
	}

	@Override
	public User updateUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub

	}

}
