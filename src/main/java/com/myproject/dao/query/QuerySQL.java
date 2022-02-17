package com.myproject.dao.query;

public final class QuerySQL {
    public static final String GET_USER_ID_ACCORDING_TO_INPUT = "SELECT role_id FROM users WHERE login=? AND password=?";
}
