package com.demo.springjwtrefreshtoken;

import com.demo.springjwtrefreshtoken.modal.Role;
import com.demo.springjwtrefreshtoken.modal.User;
import com.demo.springjwtrefreshtoken.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtRefreshTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtRefreshTokenApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Astro", "astro", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Don", "don", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "John", "john", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "ALice", "alice", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Alison", "alison", "password", new ArrayList<>()));

			userService.addRoleToUser("astro", "ROLE_USER");
			userService.addRoleToUser("astro", "ROLE_ADMIN");
			userService.addRoleToUser("astro", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("don", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("alice", "ROLE_ADMIN");
			userService.addRoleToUser("alison", "ROLE_SUPER_ADMIN");
		};
	}
}
