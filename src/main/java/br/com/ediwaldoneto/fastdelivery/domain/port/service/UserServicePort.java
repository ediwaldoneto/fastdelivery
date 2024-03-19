package br.com.ediwaldoneto.fastdelivery.domain.port.service;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;

public interface UserServicePort {

	void registerUser(final User user);

	User getUser(final Long id);

	User updateUser(final Long id, final User user);

	void deleteUser(final Long id);

}
