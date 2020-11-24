package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteQuery {
    public static void main(String[] args) {
        Connection conn = null;

        String url="jdbc:postgresql://localhost:5432/DBname";
        String user="id";
        String passwd="password";

        Statement stmt =null;
        String sql ="delete from member";
        try{

            //드라이버 로딩
            Class.forName("org.postgresql.Driver");
            System.out.println("driver loading Success");

            try{
                //DB접속
                conn= DriverManager.getConnection(url,user,passwd);
                System.out.println("connect success");

                stmt=conn.createStatement();
                stmt.executeUpdate(sql);

                System.out.println("executeQuery success");
                stmt.close();
                conn.close();
            }catch (SQLException e){
                System.out.println(e);
                System.out.println("DB접속에러");
            }
        }catch (Exception e){
            System.out.println("Exception: "+e);
        }
    }
}
