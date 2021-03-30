package com.example.bank.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service("authenticationSuccessHandler")

public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response

            , Authentication authentication)throws IOException {

        redirectStrategy.sendRedirect(request, response, "/admin");

    }

    private void returnJson(HttpServletResponse response)throws IOException {

        response.setStatus(HttpServletResponse.SC_OK);

        response.setCharacterEncoding("UTF-8");

        response.setContentType("application/json");

        response.getWriter().println("{\"exceptionId\":\"null\",\"messageCode\":\"200\"," +

                "\"message\": \"Login successfully.\",\"serverTime\": " + System.currentTimeMillis() +"}");

    }

}
