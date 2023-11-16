package com.sadturtleman.model;

public class Account {

    private String Id;
    private String password;
    private String usercode;

    public Account(String id, String password){
        this.Id = id;
        this.password = password;
    }

    public boolean checkAccount(){
        return true;
    }

    public String getusercode(){
        return usercode;
    }
}
