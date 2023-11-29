package com.sadturtleman.model;

import java.util.List;
import java.util.Random;

public class Account {

    private String id;
    private String password;
    private String usercode;

    public Account(String id, String password){
        this.id = id;
        this.password = password;
    }

    public boolean isValidAccount(){
        List<String[]> ls = Jdbc.getinstance().selectAll();
        
        for (String[] strings : ls) {
            if (id.equals(strings[0]) && password.equals(strings[1])){
                usercode = strings[2];
                return true;
            }
        }
        
        return false;
    }

    public void signUp(){
        Jdbc.getinstance().addValue(id, password, String.valueOf(new Random().nextInt(10000)));
    }
    
    public String getusercode(){
        if (usercode == null){return "";}
        return usercode;
    }
}
 