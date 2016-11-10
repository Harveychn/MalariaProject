package com.zxh.ssm.module.login.pojo;

/**
 * Created by R丶sJournal on 2016/11/6.
 */
public class User {
    private int userID;
    private String userName;
    private String userPassword;

    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userNamePassword) {
        this.userPassword = userNamePassword;
    }
}
