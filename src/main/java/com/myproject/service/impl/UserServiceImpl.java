package com.myproject.service.impl;

import com.myproject.dao.impl.UserDao;
import com.myproject.entity.User;
import com.myproject.entity.UserRole;
import com.myproject.exception.UserException;
import com.myproject.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private UserRole userRole;


    public UserServiceImpl getInstance() {
        return new UserServiceImpl();
    }
    @Override
    public String logInValidation(String login, char[] password) throws UserException {
        //todo validate date on front
        userDao = new UserDao();
        int userId = userDao.getUserRoleAccordingToInput(login,password);
        System.out.println("userId IN UserServiceImpl " + userId);
        return userRole.getRoleId(userId);
    }

    @Override
    public boolean setUserRole(String login, char[] password) {
        return false;
    }

    @Override
    public User registerNewUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public boolean updateUserBalance(double balance) {
        return false;
    }

    @Override
    public void updateUserStatus(User user) {

    }
}
