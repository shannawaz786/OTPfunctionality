package com.demo.otpservice.model;


import javax.persistence.*;

@Entity(name="user_data")
@Table(name="user_data")
public class UserData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private long id;

    @Column(name="username")
    private String username;

    public UserData() {
    }

    public UserData(long id, String username) {
        this.id = id;
        this.username = username;
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
}
