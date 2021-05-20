package com.ua.handlers;

import com.ua.domain.User;
import com.ua.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Component
public class AccessHandlerInterceptor extends HandlerInterceptorAdapter {

    private final Logger log = LoggerFactory.getLogger(AccessHandlerInterceptor.class);
    private final UserRepository userRepository;

    public AccessHandlerInterceptor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

        log.info("[AccessHandlerInterceptor]: " + "In postHandle method");
        if (!isHasAccess(request.getUserPrincipal())) {
            modelAndView.getModelMap().put("message", "You aren't student!");

            Long userId = userRepository.findUserByUsername(request.getUserPrincipal().getName()).getId();
            log.info("userId ={}", userId);

            modelAndView.setViewName("main");
            response.sendRedirect("/main");

        }

    }

    private boolean isHasAccess(Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        if (user != null) {
            log.info("Username: " + user.getUsername() + " isAdmin: " + user.isAdmin() + " isStudent: " + user.isStudent());
            return user.isAdmin() || user.isStudent();
        }
        return false;
    }

}
