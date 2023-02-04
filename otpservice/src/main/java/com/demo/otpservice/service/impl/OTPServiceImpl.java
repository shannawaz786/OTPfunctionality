package com.demo.otpservice.service.impl;

import com.demo.otpservice.model.Otp;
import com.demo.otpservice.model.UserData;
import com.demo.otpservice.repository.OtpRepo;
import com.demo.otpservice.repository.UserRepo;
import com.demo.otpservice.response.GetOTPResponse;
import com.demo.otpservice.response.ValidateOTPResponse;
import com.demo.otpservice.service.OTPService;
import com.demo.otpservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;

@Service
public class OTPServiceImpl implements OTPService {


    @Autowired
    OtpRepo otpRepo;


    @Autowired
    UserRepo userRepo;


    Random random = new Random();


    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public GetOTPResponse getOTP(String username) {
        Otp otp =new Otp();
        Otp otpResult =new Otp();
        int updateRes=0;
        GetOTPResponse getOTPResponse= new GetOTPResponse();
        try {
            if (!username.isEmpty()) {
                //create unique OTP
                StringBuilder otp_string = new StringBuilder();
                for (int i = 0; i < 6; i++) {

                    // returns pseudo-random value between 0 and 9
                    int randomNumber = random.nextInt(8);
                    otp_string.append(randomNumber + 1);
                }
                int otp_pin = Integer.parseInt(otp_string.toString());


                Otp otp_temp = new Otp();
                otp_temp = otpRepo.getByUserId(username);
                if (otp_temp != null) {
                    updateRes = otpRepo.updateOtp(username, otp_pin, Timestamp.from(Instant.now()));
                } else {
                    otp.setOtp(otp_pin);
                    otp.setUsername(username);
                    otp.setCreatedTimestamp(Timestamp.from(Instant.now()));
                    //save to DB
                    otpResult = otpRepo.save(otp);
                }

//            check if OTP is updated or created newly for new user and prepare API Response
                if (otpResult.getId() > 0 || updateRes > 0) {
                    //Here We should not send OTP directly but via Email/SMS,
                    // For demo  purpose I am sending otp in response so that
                    // we do not have to look manually into the database
                    // and provide that otp to validateOTP API
                    getOTPResponse.setOtp(otp_pin);
                    getOTPResponse.setUsername(username);
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        return getOTPResponse;
    }

    @Override
    public ValidateOTPResponse validateOTP(String username, int otp) {
        ValidateOTPResponse validateOTPResponse= new ValidateOTPResponse();

        try{
            if(!username.isBlank() && otp>0){
                Otp savedOTPEntry = otpRepo.getByUserId(username);
                if(otp==savedOTPEntry.getOtp()){
//                    OTP is valid
                    UserData userData =  new UserData();
                    userData.setUsername(username);
                    userData=userRepo.save(userData);

                    validateOTPResponse.setUserId(userData.getId());
                    validateOTPResponse.setUsername(userData.getUsername());
                    validateOTPResponse.setToken(jwtUtil.generateToken(String.valueOf(userData.getId())));

                }else {
//                    OTP is Invalid

                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return validateOTPResponse;
    }

}
