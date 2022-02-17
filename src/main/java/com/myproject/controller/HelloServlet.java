package com.myproject.controller;

import com.myproject.controller.command.*;
import com.myproject.controller.command.util.GeneralConstant;
import com.myproject.exception.UserException;

import java.io.*;
import java.util.HashSet;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(HelloServlet.class.getName());

    public void init(ServletConfig servletConfig) {
        servletConfig.getServletContext().setAttribute(GeneralConstant.LOGGED_USERS, new HashSet<>());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            processTheRequest(request, response);
        } catch (UserException e) {
            System.out.println("Problem with DB");
            e.printStackTrace();
        }
        logger.info("GET METHOD WORK");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processTheRequest(req, resp);
        } catch (UserException e) {
            System.out.println("Problem with DB");
            e.printStackTrace();
        }
        logger.info("POST METHOD WORK");
    }

    public void destroy() {
    }

    private void processTheRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, UserException {
        String action = request.getParameter(GeneralConstant.ACTION);
        logger.info("Action " + action);
        logger.info("Role " + request.getParameter("login"));
//        if (action.equals("logo")){
//            UserDao userDao = new UserDao();
//            int userRoleAccordingToInput = userDao.getUserRoleAccordingToInput(request.getParameter("login"), request.getParameter("password").toCharArray());
//            System.out.println("userRoleAccordingToInput " + userRoleAccordingToInput);
//        }

        System.out.println(request.getParameter("login") + " " + request.getParameter("password"));

        String str = request.getContextPath();
        Command command = PageAction.getCommand(action);

        assert command != null;
        Route route = command.execute(request, response);

        logger.info("route " + route.getPathOfThePage());
        String path = route.getPathOfThePage();
        if (route.getRoute().equals(Route.RouteType.FORWARD)) {
            request.getRequestDispatcher(route.getPathOfThePage()).forward(request, response);
        } else if (route.getPathOfThePage().contains(GeneralConstant.REDIRECT)){
            response.sendRedirect(path.replaceAll(GeneralConstant.REDIRECT, GeneralConstant.CAR));
        }else{
            response.sendRedirect(str + route.getPathOfThePage());
        }

        if (route.getPathOfThePage().equals("")){
            System.out.println("HEREEEEE");
        }
    }

}