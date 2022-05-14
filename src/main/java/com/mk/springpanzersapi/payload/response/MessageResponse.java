package com.mk.springpanzersapi.payload.response;

public class MessageResponse {
    private String message;
    private String type;
    private boolean success;

    public MessageResponse(String message, String type, boolean success) {
        this.message = message;
        this.type = type;
        this.success = success;
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
}
