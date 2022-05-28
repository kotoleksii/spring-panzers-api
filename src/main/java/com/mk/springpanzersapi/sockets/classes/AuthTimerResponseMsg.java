package com.mk.springpanzersapi.sockets.classes;

public class AuthTimerResponseMsg {
    private int minutes;
    private int seconds;
    public AuthTimerResponseMsg(){}
    public AuthTimerResponseMsg(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
