package br.com.siges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SigesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigesApplication.class, args);

	}

}
