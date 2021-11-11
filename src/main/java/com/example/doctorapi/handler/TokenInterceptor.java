package com.example.doctorapi.handler;

import com.example.doctorapi.common.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    private static final ThreadLocal<Integer> tl = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("Authorization");

        JwtUtil jwtUntil = new JwtUtil();
        Integer userId = jwtUntil.verifyTokenAndGetUserId(token);

        log.info(userId.toString());
        if (userId == 0) {
            tl.set(userId);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        tl.remove();
    }

    public static Integer getLoginUser() {
        return tl.get();
    }
}
