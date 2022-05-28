package com.mk.springpanzersapi.sockets.classes;

public class AuthTimerRequestMsg {
    private int minutes;
    private int seconds;

    private String email;

    public AuthTimerRequestMsg() {
    }

    public AuthTimerRequestMsg(int minutes, int seconds, String email) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.email = email;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getEmail() {
        return email;
    }
}
