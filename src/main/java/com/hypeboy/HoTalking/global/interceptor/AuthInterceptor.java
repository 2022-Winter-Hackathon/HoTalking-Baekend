package com.hypeboy.HoTalking.global.interceptor;

import com.hypeboy.HoTalking.domain.member.domain.entity.Member;
import com.hypeboy.HoTalking.global.annotation.AuthToken;
import com.hypeboy.HoTalking.global.error.exception.token.NoTokenException;
import com.hypeboy.HoTalking.global.lib.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //System.out.println("handler : " + handler);
        if(!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }
        if(!(handlerMethod.getMethod().isAnnotationPresent(AuthToken.class))) {
            return true;
        }

        String token = jwtUtil.extract(request, "Bearer");
        if(token.equals("")) {
            throw new NoTokenException();
        }

        Member member = jwtUtil.validate(token);
        request.setAttribute("member", member);

        return true;
    }

}