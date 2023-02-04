package com.demo.otpservice.repository;

import com.demo.otpservice.model.Otp;
import com.demo.otpservice.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Repository
public interface UserRepo extends JpaRepository<UserData,Long> {

}
