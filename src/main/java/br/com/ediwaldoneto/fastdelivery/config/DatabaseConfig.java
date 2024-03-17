package br.com.ediwaldoneto.fastdelivery.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String datasourceUsername;

	@Value("${spring.datasource.password}")
	private String datasourcePassword;

//	@Value("${spring.datasource.schema}")
//	private String datasourceSchema;

	@Value("${spring.datasource.driver-class-name}")
	private String driverName;

	@Bean
	public DataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl(datasourceUrl);
		dataSource.setUsername(datasourceUsername);
		dataSource.setPassword(datasourcePassword);
//		dataSource.setSchema(datasourceSchema);
		dataSource.setDriverClassName(driverName);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
