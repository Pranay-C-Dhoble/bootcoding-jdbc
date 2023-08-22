package com.bootcoding.jdbc.method;

import com.bootcoding.jdbc.utils.DBConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUsingMethod {

    public List<Customer> getAllCustomers(){
        try{

            Connection connection = DBConnectionUtils.getConnection();
            Statement statement = connection.createStatement();
            String query  =  "SELECT * FROM customer";
            ResultSet rs = statement.executeQuery(query);

            // Extract
            List<Customer> customers = new ArrayList<>();
            while(rs.next()){
                // Single Row
                int customerId = rs.getInt("customer_id");
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString("email");
                int salesManId = rs.getInt("salesman_id");

                Customer customer = new Customer();
                customer.setCustomer_id(customerId);
                customer.setCustomer_name(name);
                customer.setCity(city);
                customer.setEmail(email);
                customer.setSalesman_id(salesManId);

                customers.add(customer);
            }
            return customers;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    // Get Customer Count by Salesman Id
    public Map<Integer, Integer> getCustomerCountBySalesmanId(){
        try{

            Connection connection = DBConnectionUtils.getConnection();
            Statement statement = connection.createStatement();
            String query  =  "SELECT salesman_id, count(*) from customer group by salesman_id";
            ResultSet rs = statement.executeQuery(query);

            Map<Integer, Integer> map = new HashMap();
            while(rs.next()){
                int salesman_id = rs.getInt("salesman_id");
                int count = rs.getInt("count");
                map.put(salesman_id, count);
            }

            return map;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    public int getTotalCustomerCount(){
        try{

            Connection connection = DBConnectionUtils.getConnection();
            Statement statement = connection.createStatement();
            String query  =  "SELECT count(*) FROM customer";
            ResultSet rs = statement.executeQuery(query);

            if(rs.next()){
                int count = rs.getInt("count");
                return count;
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    // Get all customers

    // Tell me how many customers we have
    // Tell me how many customer belongs to specific city we have
    // SELECT COUNT(*) from customer where city = 'specific';

    // Get all customers who belong to specific CITY

    // Get all customers which handled by specific salesman

    // Get a Customer by customer Id

    // Business Logic + JDBC Code
}