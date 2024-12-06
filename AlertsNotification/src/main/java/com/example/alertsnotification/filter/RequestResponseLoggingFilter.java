package com.example.alertsnotification.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestResponseLoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(RequestResponseLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Log request details
        logger.info("Incoming Request: {} {}", httpRequest.getMethod(), httpRequest.getRequestURI());

        // Proceed with the next filter in the chain
        chain.doFilter(request, response);

        // Log response details
        logger.info("Outgoing Response: {} {}", httpResponse.getStatus(), httpResponse.getContentType());
    }
}
