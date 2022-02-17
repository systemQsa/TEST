package com.myproject.validation;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("resources",new Locale("uk","UA"));
        System.out.println(bundle.getString("label.Username"));
    }
}
