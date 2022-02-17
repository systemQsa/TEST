package com.myproject.controller.command;

import com.myproject.controller.command.util.CommandUtil;
import com.myproject.controller.command.util.GeneralConstant;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {

    @Override
    public Route execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        // ToDo delete current user (context & session)
        Object userName = context.getAttribute(GeneralConstant.USER_NAME);
        System.out.println("userName Logout "+userName + " " + request.getSession().getAttribute(GeneralConstant.ROLE));
        if (CommandUtil.userIsLogged(request)) {

            CommandUtil.setRoleForUser(request, GeneralConstant.EMPTY_STRING, context.toString());
            context.setAttribute(GeneralConstant.USER_NAME, null);
            request.getSession().setAttribute(GeneralConstant.ROLE,null);
            session.invalidate();
        }
         System.out.println(request.getSession().getAttribute(GeneralConstant.LOGGED_USERS));
        Route route = new Route();
        route.setPathOfThePage(ConstantPage.HOME_PAGE);
        route.setRoute(Route.RouteType.REDIRECT);
        return route;
    }
}
