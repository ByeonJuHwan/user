package com.join.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Data
public class UserDto {

    @NotBlank
    @Length(min = 2,max = 8)
    private String userId;

    @NotBlank
    @Length(min = 2,max = 8)
    private String password;
}
