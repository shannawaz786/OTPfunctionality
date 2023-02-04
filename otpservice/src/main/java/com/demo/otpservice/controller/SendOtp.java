package com.demo.otpservice.controller;

import com.demo.otpservice.model.Otp;
import com.demo.otpservice.response.GetOTPResponse;
import com.demo.otpservice.response.ValidateOTPResponse;
import com.demo.otpservice.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/otp")
@RestController
public class SendOtp {


    @Autowired
    OTPService otpService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("userform",new Otp());
        return "index";
    }
    @GetMapping
    public ResponseEntity<GetOTPResponse> getOTP(@RequestParam String username){
        GetOTPResponse getOTPResponse= new GetOTPResponse();
        getOTPResponse=otpService.getOTP(username);
        return ResponseEntity.status(HttpStatus.OK).body(getOTPResponse);
    }

    @GetMapping("/validate")
    public ResponseEntity<ValidateOTPResponse> validateOTP(@RequestParam String username,@RequestParam int otp){
        ValidateOTPResponse validateOTPResponse= new ValidateOTPResponse();
        validateOTPResponse=otpService.validateOTP(username,otp);

        return ResponseEntity.status(HttpStatus.OK).body(validateOTPResponse);
    }
}
