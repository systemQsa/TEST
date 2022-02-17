package com.myproject.controller.command;

import com.myproject.controller.command.util.CommandUtil;
import com.myproject.controller.command.util.DefineRouteForUser;
import com.myproject.controller.command.util.GeneralConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command{

    @Override
    public Route execute(HttpServletRequest request, HttpServletResponse response) {
        //todo validate fields add to DB data
        CommandUtil.setRoleForUser(request,GeneralConstant.USER,request.getParameter(GeneralConstant.LOGIN));
        Users.addUser(request.getParameter(GeneralConstant.LOGIN),GeneralConstant.USER);
        Route route = new Route();
        route.setPathOfThePage(DefineRouteForUser.getPagePathDependOnUserRole(GeneralConstant.USER));
        route.setRoute(Route.RouteType.REDIRECT);
        return route;
    }
}
