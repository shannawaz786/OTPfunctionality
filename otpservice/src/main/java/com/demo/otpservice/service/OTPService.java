package com.demo.otpservice.service;

import com.demo.otpservice.response.GetOTPResponse;
import com.demo.otpservice.response.ValidateOTPResponse;

public interface OTPService {
    public GetOTPResponse getOTP(String username);
    public ValidateOTPResponse validateOTP(String username, int otp);
}
