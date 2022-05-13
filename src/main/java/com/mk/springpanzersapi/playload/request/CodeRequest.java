package com.mk.springpanzersapi.playload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CodeRequest {

    @NotBlank
    @Size(min = 6, max = 6)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
