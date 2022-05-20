package com.mk.springpanzersapi.payload.response;

public class MessageResponse {
    private String message;
    private String type;
    private String token;
    private boolean success;

    public MessageResponse(String message, String type, String token, boolean success) {
        this.message = message;
        this.type = type;
        this.success = success;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean isSuccess) { this.success = success; }
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public String getToken() { return token; }
    public void setToken(String token) {this.token = token;}
}
