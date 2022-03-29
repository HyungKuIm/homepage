package com.oraclejava.homepage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oraclejava.homepage.dto.Member;
import com.oraclejava.homepage.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    String loginForm(@ModelAttribute LoginBean loginBean) {
        return "login/loginForm";
    }

    @PostMapping("/login")
    String login(@Validated @ModelAttribute LoginBean loginBean,
                    BindingResult bindingResult,
                    @RequestParam(defaultValue = "/") String redirectURL,
                    HttpServletRequest request) {
                
                if (bindingResult.hasErrors()) {
                    return loginForm(loginBean);
                }          

                Member loginMember = loginService.login(loginBean.getLoginId(), loginBean.getPassword());

                if (loginMember == null) {
                    bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
                    return loginForm(loginBean);
                }

                //로그인 성공 처리
                HttpSession session = request.getSession();
                session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);

                return "redirect:" + redirectURL;
    }

    @GetMapping("/logout")
    String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}
