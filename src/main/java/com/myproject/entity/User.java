package com.myproject.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class User {
    private long userId;
    private String firstName;
    private String LastName;
    private String serialPassportNumber;
    private String login;
    private char[] password;
    private UserRole userRole;
    private Timestamp registerDate;
    private BigDecimal balance;
    private char isBanned;

    public static class UserBuilder {
        private final User user;

        public UserBuilder() {
            user = new User();
        }

        public UserBuilder setUserId(long userId) {
            user.userId = userId;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            user.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            user.LastName = lastName;
            return this;
        }

        public UserBuilder setSerialPassportNumber(String serialPassportNumber) {
            user.serialPassportNumber = serialPassportNumber;
            return this;
        }

        public UserBuilder setLogin(String login) {
            user.login = login;
            return this;
        }

        public UserBuilder setPassword(char[] password) {
            user.password = password;
            return this;
        }

        public UserBuilder setRegisterDate(Timestamp registerDate) {
            user.registerDate = registerDate;
            return this;
        }

        public UserBuilder setBalance(BigDecimal balance) {
            user.balance = balance;
            return this;
        }

        public UserBuilder setIsBanned(char isBanned) {
            user.isBanned = isBanned;
            return this;
        }

        public User build() {
            return user;
        }

    }


}
