package com.csy.bo;

/**
 * Created by csypc on 2015/10/17.
 */
public class Simulation {
    private String username;

    private String password;

    private CommonDate commonDate;

    public CommonDate getCommonDate() {
        return commonDate;
    }

    public void setCommonDate(CommonDate commonDate) {
        this.commonDate = commonDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
