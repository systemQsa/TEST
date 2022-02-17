package com.myproject.controller.command.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Logger;

public class CommandUtil {
    private static final Logger logger = Logger.getLogger(CommandUtil.class.getName());
    private static final HashMap<String, String> loggedUsers = new HashMap<>();

    public static void setRoleForUser(HttpServletRequest req, String role, String login) {
        HttpSession session = req.getSession();
        ServletContext context = req.getServletContext();
        context.setAttribute(GeneralConstant.USER_NAME, login);
        session.setAttribute(GeneralConstant.ROLE, role);
        req.setAttribute(GeneralConstant.LOGIN,login);
        loggedUsers.put(login,role);
        logger.info("setRoleForUser() method");
    }

    public static boolean userIsLogged(HttpServletRequest request) {
        //todo get all logged users!
        HashMap<String, String> map = Users.getMap();
        ServletContext context = request.getServletContext();
        String userName = (String) context.getAttribute("userName");
        //todo  create structure to store logged users / check if  user is logged!!!
        if (loggedUsers.containsKey(userName) && Objects.equals(request.getSession().getAttribute(GeneralConstant.ROLE),GeneralConstant.ADMIN)) {
            logger.info("userIsLogged() method");
            return true;
        }
        loggedUsers.put(request.getParameter(GeneralConstant.LOGIN), request.getParameter(GeneralConstant.ROLE));
        request.getSession().getServletContext().setAttribute(GeneralConstant.LOGGED_USERS, loggedUsers);
        logger.info("userIsLogged() method");
        return false;
    }
    public static String getUserRoleFromPage(HttpServletRequest request){
        String role = request.getSession().getAttribute("role").toString();
        if (role!= null){
            logger.info("getUserRoleFromPage() method");
            return role;
        }
        logger.info("getUserRoleFromPage() method");
        return GeneralConstant.EMPTY_STRING;
    }

    public static HashMap<String, String> getLoggedUsers() {
        return loggedUsers;
    }
}
