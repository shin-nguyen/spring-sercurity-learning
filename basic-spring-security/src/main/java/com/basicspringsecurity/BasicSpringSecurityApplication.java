package com.basicspringsecurity;

import com.basicspringsecurity.entity.Role;
import com.basicspringsecurity.entity.User;
import com.basicspringsecurity.repository.RoleRepository;
import com.basicspringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BasicSpringSecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BasicSpringSecurityApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepository.saveAndFlush(adminRole);

        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepository.saveAndFlush(userRole);

        User user1 = new User();
        user1.setUsername("user1");
        user1.setPassword(passwordEncoder.encode("1234"));
        user1.getRoles().add(adminRole);
        userRepository.saveAndFlush(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword(passwordEncoder.encode("1234"));
        user2.getRoles().add(userRole);
        userRepository.saveAndFlush(user2);
    }
}
