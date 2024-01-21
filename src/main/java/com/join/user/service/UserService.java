package com.join.user.service;

import com.join.user.domain.User;
import com.join.user.dto.UserDto;
import com.join.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public void joinUser(UserDto userDto) {
        User user = User.builder()
                .userId(userDto.getUserId())
                .password(userDto.getPassword())
                .name(userDto.getName())
                .build();
        userRepository.save(user);
    }

}
