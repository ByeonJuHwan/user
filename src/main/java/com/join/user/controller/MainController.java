package com.join.user.controller;

import com.join.user.domain.User;
import com.join.user.dto.LoginDto;
import com.join.user.service.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final LoginService loginService;

    @GetMapping("/")
    public String homePage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "/main";
        }
        User user = (User) session.getAttribute("Session_Id");
        if (user == null) {
            return "/main";
        }

        model.addAttribute("user", user);
        return "loginMain";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("user") LoginDto loginDto , BindingResult bindingResult,
                        HttpServletRequest request) {
        // loginDto 에 문제가 생겼을때
        if (bindingResult.hasErrors()) {
            return "login";
        }

        // 로그인 로직
        User loginedUser = loginService.login(loginDto.getUserId(), loginDto.getPassword());
        // 로그인 로직에 문제 생겼을 경우 오류 메세지와 함께 bindingResult 에 redirect
        if (loginedUser == null) {
            bindingResult.reject("loginFailed", "아이디/비밀번호가 일치 하지 않습니다.");
        }

        // 로그인이 성공하면 session 을 만들고 저장한다.
        HttpSession session = request.getSession();
        session.setAttribute("Session_Id", loginedUser);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "main";
    }
}
