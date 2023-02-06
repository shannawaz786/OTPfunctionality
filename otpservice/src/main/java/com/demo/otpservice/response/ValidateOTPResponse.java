package com.demo.otpservice.response;

public class ValidateOTPResponse {
    private  int responseCode;
    private String responseMsg;
    private Long userId;
    private String username;
    private String token;

    public ValidateOTPResponse() {
    }

    public ValidateOTPResponse(int responseCode, String responseMsg, Long userId, String username, String token) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
        this.userId = userId;
        this.username = username;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
