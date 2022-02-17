package com.myproject.service;


import com.myproject.entity.User;
import com.myproject.exception.UserException;

public interface UserService {
    String logInValidation(String login,char[]password) throws UserException;
    boolean setUserRole(String login,char[]password);
    User registerNewUser(User user);
    User deleteUser(User user);
    boolean updateUserBalance(double balance);
    void updateUserStatus(User user);
    UserService getInstance();
}
