package com.example.test1.Service1;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class connection {
    Connection con = null;
    public static Connection connectDB() {

        try {
            // Importing and registering drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sakila",
                    "root", "Raleigh!23");

            return con;
        } catch (SQLException e) {

            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


