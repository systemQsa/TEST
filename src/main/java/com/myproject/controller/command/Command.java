package com.myproject.controller.command;

import com.myproject.exception.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    Route execute(HttpServletRequest request, HttpServletResponse response) throws UserException;
}
