package com.myproject.controller.filter;


import com.myproject.controller.command.ConstantPage;
import com.myproject.controller.command.util.GeneralConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RedirectFilter implements Filter {
    private static final Logger logger = Logger.getLogger(RedirectFilter.class.getName());
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object userRole = request.getSession().getAttribute(GeneralConstant.ROLE);
        response.setHeader(GeneralConstant.CACHE_CONTROL, GeneralConstant.NO_STORE_MUST_REVALIDATE);
        response.setHeader(GeneralConstant.PRAGMA, GeneralConstant.NO_CACHE);
        response.setDateHeader(GeneralConstant.EXPIRES, 0);
        if (request.getRequestURI().contains(GeneralConstant.ADMIN) && userRole != null){
            request.getRequestDispatcher(ConstantPage.WEB_INF_FULL_PATH_TO_ADMIN).forward(request,response);
        }
        if (request.getRequestURI().contains(GeneralConstant.USER) && userRole != null){
            request.getRequestDispatcher(ConstantPage.WEB_INF_FULL_PATH_TO_USER).forward(request,response);
        }
        logger.info("REDIRECT FILTER");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
    }
}
