package com.join.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String userId;
    private String password;

    @Builder
    public User(Long id, String name, String userId, String password) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.password = password;
    }
}
