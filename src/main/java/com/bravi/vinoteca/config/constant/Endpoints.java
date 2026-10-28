package com.bravi.vinoteca.config.constant;

public class Endpoints {

    private Endpoints() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class");
    }

    public static final String BASE_URL = "/api/v1/";
    public static final String AUTH = BASE_URL + "auth";
    public static final String REGISTER = "register";
    public static final String LOGIN = "login";

}
