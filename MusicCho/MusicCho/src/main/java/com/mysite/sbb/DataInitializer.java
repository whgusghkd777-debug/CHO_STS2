package com.mysite.sbb;

import com.mysite.sbb.user.UserRepository;
import com.mysite.sbb.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final UserService userService;
    private final UserRepository userRepository;

    @Bean
    public CommandLineRunner initAdmin() {
        return args -> {
            // DB에 admin 계정이 없으면 자동 생성
            if (userRepository.findByUsername("admin").isEmpty()) {
                userService.create("admin", "1234", "admin@local", "ADMIN");
                System.out.println("✅ Admin 계정 생성 완료: admin / 1234");
            }
        };
    }
}