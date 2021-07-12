package com.akilan.juztrade.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    private String userId;
    private String userName;
    private String password;
    private String upiId;
    private String passPhrase;

    public Users(String userId, String userName, String password, String upiId, String passPhrase) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.upiId = upiId;
        this.passPhrase = passPhrase;
    }

    public Users() {

    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
    public String getPassPhrase() {
        return passPhrase;
    }

    public void setPassPhrase(String passPhrase) {
        this.passPhrase = passPhrase;
    }
}
