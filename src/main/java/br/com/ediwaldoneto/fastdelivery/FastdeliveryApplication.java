package br.com.ediwaldoneto.fastdelivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ediwaldoneto.fastdelivery.domain.entities.User;
import br.com.ediwaldoneto.fastdelivery.domain.service.UserService;

@SpringBootApplication
public class FastdeliveryApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(FastdeliveryApplication.class, args);
	}

	@Autowired
	private UserService service;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		

		User user = service.getUser(2L);
		

	}

}
