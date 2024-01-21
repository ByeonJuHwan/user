package com.join.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginDto {
    @NotBlank
    @Length(min = 2,max = 8)
    private String userId;

    @NotBlank
    @Length(min = 2,max = 8)
    private String password;
}
