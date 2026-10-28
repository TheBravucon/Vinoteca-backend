package com.bravi.vinoteca.config;

import com.bravi.vinoteca.entity.User;
import com.bravi.vinoteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) throws Exception {
        boolean hasAdmin = userRepository.existsByRole("ADMIN");

        if (!hasAdmin) {
            if (adminEmail == null || adminPassword == null) {
                throw new Exception("Admin credentials are missing");
            }
            User admin = User.builder()
                    .nombre("Admin")
                    .apellido("Vinoteca")
                    .email(adminEmail)
                    .password(passwordEncoder.encode(adminPassword))
                    .role("ADMIN")
                    .enabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .build();

            userRepository.save(admin);
            System.out.println("Admin user created: " + adminEmail + " / " + adminPassword);
        }
    }
}
