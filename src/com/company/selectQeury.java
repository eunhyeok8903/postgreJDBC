package com.company;

import java.sql.*;

public class selectQeury {
    public static void main(String[] args) {
        Connection conn = null;

        String url="jdbc:postgresql://localhost:5432/dbName";
        String user="id";
        String passwd="password";

        ResultSet rs= null; //쿼리 실행 결과값 받아오기
        Statement stmt =null;
        String sql = "select * from member";
        try{

            //드라이버 로딩
            Class.forName("org.postgresql.Driver");
            System.out.println("driver loading Success");

            try{
                //DB접속
                conn= DriverManager.getConnection(url,user,passwd);
                System.out.println("connect success");

                stmt=conn.createStatement();
                rs=stmt.executeQuery(sql);

                while(rs.next()) {
                    int Id = rs.getInt("mid");
                    String Name = rs.getString("name");
                    String Number = rs.getString("number");
                    String Address = rs.getString("address");

                    System.out.println("ID : " + Id + " Name : " + Name + " Numebr : " + Number + " Address : " + Address);
                }

                System.out.println("executeQuery success");
                rs.close();
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
