package com.mk.springpanzersapi.payload.request.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SecretCodeRequest {

    @NotBlank
    @Size(min = 6, max = 6)
    private String code;

    @NotBlank
    @Size(max = 50)
    private String email;

    public String getCode() {return code;}

    public void setCode(String code) {this.code = code;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
