package com.join.user.controller;

import com.join.user.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Swagger 테스트 태그 1", description = "Swagger 적용기")
public class SwaggerTestController {

    @Operation(summary = "UserDto 반환", description = "기본 UserDto 를 반환 합니다.")
    @Parameter(name = "testParam",description = "Swagger 테스트 파라미터")
    @PutMapping("/swagger/userDto")
    public ResponseEntity<UserDto> swagger(@RequestParam(defaultValue = "/")String param) {
        UserDto userDto = new UserDto();
        userDto.setName("변주환");
        userDto.setUserId("test");
        userDto.setPassword("test");
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
