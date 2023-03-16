package com.example.test1.Service1;

import com.example.test1.domenModel.CustomerAddress;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Output {
    //public static void main(String[]args){
    public List<CustomerAddress> getOutput(int address_id) {
        // Stepou 2: Making connection using
        // Connection type and inbuilt function on
        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;

        con = connection.connectDB();

        // Try block to catch exception/s
        try {

            String addressId = String.valueOf(address_id);
            // SQL command data stored in String datatype
            String sql = "Select a.address_id,c.first_name,c.last_name,c.active,c.email,a.address,a.city_id,a.postal_code from sakila.address as a left join  sakila.customer as c on a.address_id=c.address_id where a.address_id=";

            p = con.prepareStatement(sql + addressId);
            rs = p.executeQuery();

            List<CustomerAddress> list1 = new ArrayList<>();
            while (rs.next()) {

                CustomerAddress customerAddress = CustomerAddress.builder()
                        .first_name(rs.getString(2))
                        .last_name(rs.getString(3))
                        .active(rs.getInt(4))
                        .email(rs.getString(5))
                        .address_id(rs.getInt(1))
                        .address(rs.getString(6))
                        .city_id(rs.getInt(7))
                        .postal_code(rs.getString(8))
                        .build();


                list1.add(customerAddress);
            }

            System.out.println(list1);
            return list1;
        }

        // Catch block to handle exception
        catch (SQLException e) {

            // Print exception pop-up on screen
            System.out.println(e);
            System.out.println(e);
            return null;
        }
    }
}

