package br.com.siges;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SigesApplication {

	public static void main(String[] args) {
		//System.out.println(new BCryptPasswordEncoder().encode("12345"));
		SpringApplication.run(SigesApplication.class, args);

	}

}
