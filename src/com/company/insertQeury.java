package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insertQeury {
    public static void main(String[] args) {
        Connection conn = null;

        String url="jdbc:postgresql://localhost:5432/dbName";
        String user="id";
        String passwd="password";

        Statement stmt =null;
        String sql1=
                "INSERT INTO librarian (lid,name,address,number) VALUES (1, 'AAA', 'Gangdong1', '010-9999-1001');" +
                        "INSERT INTO librarian (lid,name,address,number) VALUES (2, 'BBB', 'Gangdong2', '010-9999-1002');" +
                        "INSERT INTO librarian (lid,name,address,number) VALUES (3, 'BCB', 'Gangdong3', '010-9999-1003');" +
                        "INSERT INTO librarian (lid,name,address,number) VALUES (4, 'AAA', 'Gangdong3', '010-9999-1004');" +
                        "INSERT INTO librarian (lid,name,address,number) VALUES (5, 'BBB', 'Incheon4', '010-9999-1005');" +
                        "INSERT INTO librarian (lid,name,address,number) VALUES (6, 'BCD', 'Gangdong5', '010-9999-1006');";
        String sql2=
                "INSERT INTO member (mid,name,number,address) VALUES (1, 'BCD', '010-9999-1008', 'Gangdong10');" +
                        "INSERT INTO member (mid,name,number,address) VALUES (3, 'BBB', '010-9999-1002', 'Gangdong2');" +
                        "INSERT INTO member (mid,name,number,address) VALUES (4, 'FCD', '010-9999-1011', 'Gangnam5');" +
                        "INSERT INTO member (mid,name,number,address) VALUES (2, 'ZZZ', '010-9999-1009', 'Mapo11');" +
                        "INSERT INTO member (mid,name,number,address) VALUES (6, 'FFF', '010-9899-1008', 'Gangdong99');" +
                        "INSERT INTO member (mid,name,number,address) VALUES (5, 'FKK', '010-9999-1777', 'Mapo1');" +
                        "INSERT INTO member (mid,name,number,address) VALUES (7, 'FUF', '010-9999-1100', 'Gangdong85');";
        try{

            //드라이버 로딩
            Class.forName("org.postgresql.Driver");
            System.out.println("driver loading Success");

            try{
                //DB접속
                conn= DriverManager.getConnection(url,user,passwd);
                System.out.println("connect success");

                stmt=conn.createStatement();
                stmt.executeUpdate(sql1);
                stmt.executeUpdate(sql2);
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
