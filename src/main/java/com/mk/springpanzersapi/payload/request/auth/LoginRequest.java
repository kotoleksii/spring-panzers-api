package com.mk.springpanzersapi.payload.request.auth;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank
    private String nickname;

    @NotBlank
    private String password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
