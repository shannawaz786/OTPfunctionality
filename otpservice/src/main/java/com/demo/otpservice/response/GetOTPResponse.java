package com.demo.otpservice.response;

public class GetOTPResponse {
    private String username;
    private int otp;

    public GetOTPResponse() {
    }

    public GetOTPResponse(String username, int otp) {
        this.username = username;
        this.otp = otp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
