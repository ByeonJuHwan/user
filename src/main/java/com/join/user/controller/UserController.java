package com.join.user.controller;

import com.join.user.dto.UserDto;
import com.join.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/join")
    public String joinPage(Model model){
        model.addAttribute("user", new UserDto());
        return "join";
    }

    @PostMapping("/api/join")
    public String join(@Validated @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        log.info("UserDto= {}", userDto);
        if (bindingResult.hasErrors()) {
            log.error("errors = {}", bindingResult);
            return "join";
        }
        userService.joinUser(userDto);
        return "redirect:/";
    }
}
