package br.com.ediwaldoneto.fastdelivery.domain.port.service;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;

public interface UserServicePort {

	void registerUser(User user);

	User getUser(final Long id);

	User updateUser(final Long id);

	void deleteUser(final Long id);

}
