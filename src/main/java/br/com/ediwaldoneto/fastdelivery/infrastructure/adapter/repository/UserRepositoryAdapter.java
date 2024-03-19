package br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.domain.port.repository.UserRepositoryPort;
import br.com.ediwaldoneto.fastdelivery.infrastructure.exception.DuplicateEmailException;
import br.com.ediwaldoneto.fastdelivery.infrastructure.exception.GeneralException;
import br.com.ediwaldoneto.fastdelivery.util.Constants;

@Repository
public class UserRepositoryAdapter implements UserRepositoryPort {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public UserRepositoryAdapter(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(User user) {
		final String sql = "INSERT INTO usr (name, email, phone, address, type, password, id) VALUES "
				+ " (:name, :email, :phone, :address, :type, :password, nextval('delivery.usr_id_seq'::regclass)) ON CONFLICT (id) DO NOTHING";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue(Constants.NAME, user.getName());
		param.addValue(Constants.EMAIL, user.getEmail());
		param.addValue(Constants.PHONE, user.getPhone());
		param.addValue(Constants.ADDRESS, user.getAddress());
		param.addValue(Constants.TYPE, user.getType());
		param.addValue(Constants.PASSWORD, user.getPassword());
		try {
			jdbcTemplate.update(sql, param);
		} catch (DataAccessException e) {
			if (e.getCause().getLocalizedMessage().contains("Chave (email)")) {
				throw new DuplicateEmailException("The email provided is already registered.");
			}

		} catch (Exception e) {
			throw new GeneralException(e.getMessage());
		}
	}

	@Override
	public User findById(Long id) {
		final String sql = "SELECT name, email, phone, address, type, password, id FROM usr where id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return jdbcTemplate.queryForObject(sql, param, userMapper());
	}

	@Override
	public User update(User user) {
		final String sql = "UPDATE usr SET :name, :email, :phone, :address, :type, :password where id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", user.getId());
		param.addValue(Constants.NAME, user.getName());
		param.addValue(Constants.EMAIL, user.getEmail());
		param.addValue(Constants.PHONE, user.getPhone());
		param.addValue(Constants.ADDRESS, user.getAddress());
		param.addValue(Constants.TYPE, user.getType());
		param.addValue(Constants.PASSWORD, user.getPassword());
		Map<String, Object> updatedUserMap = jdbcTemplate.queryForMap(sql, param);
		return User.fromMap(updatedUserMap);

	}

	@Override
	public void delete(Long id) {
		final String sql = "DELETE FROM usr WHERE id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		jdbcTemplate.update(sql, param);

	}

	private RowMapper<User> userMapper() {
		return (rs, rowNum) -> {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			user.setAddress(rs.getString("address"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			user.setType(rs.getString("type"));
			user.setPassword(rs.getString("password"));
			return user;
		};
	}

}
