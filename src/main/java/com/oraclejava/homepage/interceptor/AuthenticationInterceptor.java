package com.oraclejava.homepage.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oraclejava.homepage.controller.SessionConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
        logger.info("preHandle");        

        HttpSession session = request.getSession();
        
        if (session.getAttribute(SessionConstants.LOGIN_MEMBER) == null) {
            logger.info("로그아웃 상태");
            //throw new Exception("로그인 해주세요!");
            response.sendRedirect("/login");
        }
        logger.info("로그인 되어있습니다.");
        //세션 시간 설정
        //session.setMaxInactiveInterval(30 * 60);  // 30분 (기본)
        return true;
    }
    
    
}
