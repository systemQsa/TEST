package com.myproject.controller.filter;

import com.myproject.controller.command.util.GeneralConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class EncodingFilter implements Filter {
    private static final Logger logger = Logger.getLogger(EncodingFilter.class.getName());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType(GeneralConstant.CONTENT_TYPE);
        servletResponse.setCharacterEncoding(GeneralConstant.ENCODING);
        servletRequest.setCharacterEncoding(GeneralConstant.ENCODING);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        logger.info("EncodingFilter working");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
       // Filter.super.destroy();
    }
}
