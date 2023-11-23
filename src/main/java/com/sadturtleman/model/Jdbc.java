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
        List<String[]> ls = new ArrayList<>();

        try {
            connect();
            rs = stmt.executeQuery("select * from account");

            while (rs.next()) {
                ls.add(new String[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }

            close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ls;
    }

    public void addValue(String id, String pw){
        try {
            connect();
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO account VALUES(?, ?, ?)");
            pstm.setString(1, id);
            pstm.setString(2, pw);
            pstm.setString(3, pw);

            pstm.execute();

            close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, user, passwd);
        stmt = conn.createStatement();
        System.out.println("연결 성공");
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
