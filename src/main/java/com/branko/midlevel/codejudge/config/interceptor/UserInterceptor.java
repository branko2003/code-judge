package com.branko.midlevel.codejudge.config.interceptor;

import com.branko.midlevel.codejudge.context.UserContext;
import com.branko.midlevel.codejudge.exception.BadRequestException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        String userId = request.getHeader("userId");

        if (userId == null || userId.isBlank()) {
            throw new BadRequestException("userId missing in header");
        }

        UserContext.setUserId(userId);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) {
        UserContext.clear();
    }
}