package com.example.spring_project.config;


import com.example.spring_project.daos.UserRepository;
import com.example.spring_project.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Data {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isPresent()) {
        } else {
            User admin = User.builder()
                    .username()
                    .hashCode(passwordEncoder.encode("Wiley"))
                    .role("ROLE_ADMIN")
                    .build();
            userRepository.save(admin);
        }

        System.out.println("Admin user created with username 'Conor' and password 'Wiley'");
    }

}
