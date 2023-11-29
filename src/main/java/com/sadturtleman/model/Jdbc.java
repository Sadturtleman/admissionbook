package com.sadturtleman.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class Jdbc {

    String url = "jdbc:postgresql://localhost:5432/Account";
    String user = "test";
    String passwd = "1234";    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    static Jdbc instance = new Jdbc();
    
    public static Jdbc getinstance(){
        return instance;
    }

    private Jdbc(){}

    public List<String[]> selectAll(){

        if (connect()){
            List<String[]> ls = new ArrayList<>();
            try {
                rs = stmt.executeQuery("select * from account");

                while (rs.next()) {
                    ls.add(new String[]{
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)});
                }

                close();
            } catch (SQLException e) {e.printStackTrace();}
            return ls;
        }
        return null;
    }

    public boolean addValue(String id, String pw, String usercode){
        if (connect()){
            try {
                PreparedStatement pstm = conn.prepareStatement("INSERT INTO account VALUES(?, ?, ?)");
                pstm.setString(1, id);
                pstm.setString(2, pw);
                pstm.setString(3, usercode);

                pstm.execute();

                close();
            } catch (SQLException e) {
                return false;
            }            
        }
        return true;
    }

    private boolean connect(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, passwd);
            stmt = conn.createStatement();            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void close(){
        try {
            if (rs != null){rs.close();}
            if (stmt != null){stmt.close();}
            if (conn != null){conn.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
