package com.lgj.webapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LGJApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(LGJApiApplication.class, args);
	}
  
	@Bean
    CommandLineRunner run(/*UserService userService*/){
        return args -> {
            /*if (userService.getUsers(Pageable.ofSize(10)).isEmpty()){
                userService.saveRole(new Role(null, "ROLE_USER"));
                userService.saveRole(new Role(null, "ROLE_MANAGER"));
                userService.saveRole(new Role(null, "ROLE_ADMIN"));
                userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
                userService.saveUser(new User(null, "Diego Johnson", "diego", "1234", new ArrayList<>()));
                userService.saveUser(new User(null, "Ashlyn Demrest", "ashlyn", "1234", new ArrayList<>()));
                userService.saveUser(new User(null, "Anibal Ludena", "anibal", "1234", new ArrayList<>()));
                userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            }*/
        };
    }

}
