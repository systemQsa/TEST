package com.myproject.dao.impl;

import com.myproject.dao.DAO;
import com.myproject.dao.connection.ConnectionPool;
import com.myproject.dao.query.QuerySQL;
import com.myproject.entity.User;
import com.myproject.exception.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserDao implements DAO<User> {
    @Override
    public List<User> findAll(User user) {
        return null;
    }

    @Override
    public User findById(User user) {
        return null;
    }

    @Override
    public User deleteById(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
    public int getUserRoleAccordingToInput(String login,char[]password) throws UserException {
        ResultSet resultSet;
        int id = 0;
        System.out.println("USER DAO 1     " + login + "  " + Arrays.toString(password));
        try(Connection connection = ConnectionPool.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(QuerySQL.GET_USER_ID_ACCORDING_TO_INPUT)){
            System.out.println("execute");
            statement.setString(1,login);
            statement.setString(2,String.valueOf(password));
            resultSet = statement.executeQuery();
            System.out.println("execute2");
            if (resultSet.next()){
                id = resultSet.getInt("role_id");
                System.out.println("id " + id);
            }

        }catch (SQLException e){
            throw new UserException("There is no user with such credentials in DB",e);
        }

        return id;
    }

}
