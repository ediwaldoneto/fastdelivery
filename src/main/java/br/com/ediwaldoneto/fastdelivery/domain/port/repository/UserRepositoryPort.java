package br.com.ediwaldoneto.fastdelivery.domain.port.repository;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;

public interface UserRepositoryPort {

	void save(User user);

	User findById(final Long id);

	User update(User user);

	void delete(final Long id);
}
