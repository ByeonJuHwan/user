package com.join.user;

import com.join.user.domain.User;
import com.join.user.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = User.builder()
                .name("변주환")
                .userId("test")
                .password("test")
                .build();

        userRepository.save(user);
    }
}
