package com.student.security.handle;

import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errMessage = "Invalid Username or Password";

        if ( exception instanceof BadCredentialsException) {
            errMessage = "Invalid Username or Password";
        } else if (exception instanceof InsufficientAuthenticationException) {
            errMessage = "Invalid Secret Key";
        } else if ( exception instanceof InternalAuthenticationServiceException) {
            errMessage = "Invalid Username or Password";
        } else if ( exception instanceof DisabledException) {
            errMessage = "Locked";
        } else if ( exception instanceof CredentialsExpiredException) {
            errMessage = "Expired password";
        } else if ( exception instanceof AccountExpiredException) {
            errMessage = "Expired account";
        } else if ( exception instanceof LockedException) {
            errMessage = "Locked";
        }

        System.out.println("exception.getMessage() = " + exception.getMessage());

        setDefaultFailureUrl("/login?error=true&exception=" + errMessage);

        super.onAuthenticationFailure(request, response, exception);
    }
}
