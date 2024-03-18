package br.com.ediwaldoneto.fastdelivery.domain.port.repository;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;

public interface UserRepositoryPort {

	void save(final User user);

	User findById(final Long id);

	User update(final User user);

	void delete(final Long id);
}
