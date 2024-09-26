package com.users.api;

import com.users.api.models.Phone;
import com.users.api.models.Role;
import com.users.api.models.UserEntity;
import com.users.api.repository.RoleRepository;
import com.users.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class ApiApplication {

	@Autowired
	private RoleRepository repository;
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<Phone> phones = new ArrayList<Phone>() ;
		Phone phone = new Phone(0, "1234567", "111111", "57", null);
		phones.add(phone);

		List<Role> roles = Stream.of(
				new Role(1, "USER"),
				new Role(2, "ADMIN")
		).collect(Collectors.toList());

		List<Role> rolesSaved = repository.saveAll(roles);

		UserEntity userEntity = new UserEntity(0, "Luis Diaz", "luis@gmail.com", passwordEncoder.encode("password123"), null, new Date(), new Date(), null, phones) ;

		// UserEntity(int id, String name, String email, String password, List<Role> roles, Date created, Date modified, Date lastLogin, List<Phone> phones)

		phone.setUserEntity(userEntity);

		UserEntity savedUserEntity = userRepository.save(userEntity);
	}

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
