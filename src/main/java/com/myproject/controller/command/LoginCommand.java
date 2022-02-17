package com.myproject.controller.command;

import com.myproject.controller.command.util.CommandUtil;
import com.myproject.controller.command.util.DefineRouteForUser;
import com.myproject.controller.command.util.GeneralConstant;
import com.myproject.exception.UserException;
import com.myproject.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class LoginCommand implements Command {
    private static final Logger logger = Logger.getLogger(LoginCommand.class.getName());
    private UserService userService;

    @Override
    public Route execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        //todo validate fields
        Route route = new Route();
        String login = request.getParameter(GeneralConstant.LOGIN);
        char[]password = request.getParameter("password").toCharArray();

        System.out.println(request.getParameter(GeneralConstant.PASSWORD));
        logger.info("USER LOGIN  == " + login);

        if (login == null || login.equals(GeneralConstant.EMPTY_STRING)) {
            route.setPathOfThePage(ConstantPage.HOME_PAGE);
        }
        if (CommandUtil.userIsLogged(request)) {
            String userRole = CommandUtil.getUserRoleFromPage(request);
            route.setPathOfThePage(DefineRouteForUser.getPagePathDependOnUserRole(userRole));
            logger.info("user is logged");
       }else{
            System.out.println("#######");
            UserService instance = userService.getInstance();
            System.out.println(instance.getClass().getName());
            String role =  instance.logInValidation(login,password);
            System.out.println("ROLE  " + role);
            System.out.println("all is good found user n DB");
            //String role = Users.getRole(login);
            CommandUtil.setRoleForUser(request,role,login);
            route.setPathOfThePage(DefineRouteForUser.getPagePathDependOnUserRole(role));
            logger.info("user NOT logged!");

        }
        //todo: check login and role with DB

        route.setRoute(Route.RouteType.REDIRECT);
        //request.getSession().getServletContext().setAttribute("loggedUsers", login);
        return route;
    }
}
