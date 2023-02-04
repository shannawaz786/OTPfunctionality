package com.demo.otpservice.repository;

import com.demo.otpservice.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;

@Repository
public interface OtpRepo extends JpaRepository<Otp,Long> {
    @Query(value = "select * from otp u where u.username=?1",nativeQuery = true)
    Otp getByUserId(String username);

    @Transactional
    @Modifying
    @Query("update otp u set otp=?2,created_on=?3 where u.username=?1")
    int updateOtp(String username, int otp, Timestamp timestamp);

}
