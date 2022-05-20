package com.mk.springpanzersapi.enums;

public enum Messages {
    NICKNAME_ERROR("Nickname is already taken!"),
    EMAIL_ERROR("Email is already in use!"),
    AUTH_CODE("Redirect to secret code!"),
    SUCCESS_AUTH("You are authenticated!"),
    INVALID_CODE("Invalid code!"),
    MATCH_CODE("code is matching!"),
    DELETE_CODE("code was deleted!"),
    BAD_REQUEST("Something wrong!");

    public final String msg;
    Messages(String s) {
        msg = s;
    }
}
