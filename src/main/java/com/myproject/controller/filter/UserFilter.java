package com.myproject.controller.filter;


import com.myproject.controller.command.ConstantPage;
import com.myproject.controller.command.util.GeneralConstant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Logger;

public class UserFilter implements Filter {
    private static final Logger logger = Logger.getLogger(UserFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("URL " + request.getRequestURI());

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader(GeneralConstant.CACHE_CONTROL, GeneralConstant.NO_STORE_MUST_REVALIDATE);
        response.setHeader(GeneralConstant.PRAGMA, GeneralConstant.NO_CACHE);
        response.setDateHeader(GeneralConstant.EXPIRES, 0);
        String userRole = (String) request.getSession().getAttribute(GeneralConstant.ROLE);
        String urlPath = request.getRequestURI();
        if ((urlPath.contains(GeneralConstant.LOGIN)
                || urlPath.contains(GeneralConstant.REGISTER))
                && ((Objects.equals(userRole, GeneralConstant.ADMIN)
                || Objects.equals(userRole, GeneralConstant.USER)
                || Objects.equals(userRole, GeneralConstant.MANAGER)))) {
            request.getServletContext().setAttribute(GeneralConstant.USER_NAME,null);
            request.getSession().setAttribute(GeneralConstant.ROLE, null);
            response.sendRedirect(ConstantPage.ROOT);
            logger.info("UserFilter WORKING");
        }
        if (urlPath.contains(GeneralConstant.ADMIN) && userRole == null){
            response.sendRedirect(ConstantPage.ROOT);
        }
        logger.info("UserFilter WORKING");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Filter.super.destroy();
    }
}
/*
   if ((urlPath.contains(GeneralConstant.LOGIN)
                || urlPath.contains(GeneralConstant.REGISTER))
                && ((Objects.equals(userRole, GeneralConstant.ADMIN)
                || Objects.equals(userRole, GeneralConstant.USER)
                || Objects.equals(userRole, GeneralConstant.MANAGER)))) {
            request.getSession().setAttribute(GeneralConstant.ROLE, null);
            request.getSession().invalidate();
            request.getRequestDispatcher(ConstantPage.ROOT).forward(request, response);
            logger.info("some problem with UserFilter");
        }

        if (urlPath.contains(GeneralConstant.LOGIN) && Objects.equals(userRole, GeneralConstant.ADMIN)) {
            request.getSession().setAttribute(GeneralConstant.ROLE,null);
            response.sendRedirect(ConstantPage.ROOT);
            logger.info("UserFilter");
        }
 */