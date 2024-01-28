package com.join.user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Swagger 테스트 태그 2", description = "Swagger 적용기")
public class SwaggerTestController2 {

    @GetMapping("/swagger/{name}")
    public ResponseEntity<String> swagger(@PathVariable String name) {
        return ResponseEntity.ok(String.format("Hello %s.", name));
    }
}
