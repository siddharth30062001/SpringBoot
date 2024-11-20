package com.bridgelabz.springbootexample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabase{

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/empdb";
        String user = "root";
        String password = "rajput@2001";
        return DriverManager.getConnection(url, user, password);
    }

    public static void createTable(Connection conn){
        String query= "create table if not exists employee("
                +"id int primary key,"+
                "name varchar(15) not null,"+
                "salary double not null,"+
                "city varchar(15) not null,"+
                "age int not null"+
                ")";

        try(Statement stmt =conn.createStatement()){
            stmt.executeQuery(query);
        }
        catch (SQLException q){
            q.printStackTrace();
        }


    }
}
