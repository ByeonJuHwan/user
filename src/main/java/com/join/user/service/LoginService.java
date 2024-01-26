package com.join.user.service;

import com.join.user.domain.User;
import com.join.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public User login(String userId, String password) {
        return userRepository.findByUserId(userId)
                .stream()
                .filter(m-> m.getPassword().equals(password))
                .findAny().orElse(null);
    }
}
