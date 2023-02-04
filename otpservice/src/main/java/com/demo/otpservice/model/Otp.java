package com.demo.otpservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "otp")
@Table(name="otp")
public class Otp {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private long id;

    @Column(name="username")
    private String username;

    @Column(name="otp")
    private int otp;

    @Column(name="created_on")
    private Date createdTimestamp;

    public Otp() {
    }

    public Otp(int id, String username, int otp, Date createdTimestamp) {
        this.id = id;
        this.username = username;
        this.otp = otp;
        this.createdTimestamp = createdTimestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }
}
