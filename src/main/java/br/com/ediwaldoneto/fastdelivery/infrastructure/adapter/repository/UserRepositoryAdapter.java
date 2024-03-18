package br.com.ediwaldoneto.fastdelivery.infrastructure.adapter.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.domain.port.repository.UserRepositoryPort;

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
		param.addValue("name", user.getName());
		param.addValue("email", user.getEmail());
		param.addValue("phone", user.getEmail());
		param.addValue("address", user.getAddress());
		param.addValue("type", user.getType());
		param.addValue("password", user.getPassword());
		jdbcTemplate.update(sql, param);
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
		param.addValue("name", user.getName());
		param.addValue("email", user.getEmail());
		param.addValue("phone", user.getEmail());
		param.addValue("address", user.getAddress());
		param.addValue("type", user.getType());
		param.addValue("password", user.getPassword());
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
