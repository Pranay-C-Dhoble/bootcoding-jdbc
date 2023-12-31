package com.bootcoding.jdbc.method;

import java.util.List;
import java.util.Map;

public class JDBCApp {
    public static void main(String[] args) {
        JdbcUsingMethod jdbcUsingMethod = new JdbcUsingMethod();//creating object of JdbcUsingMethod class
        // Get All Customers
        System.out.println("Get All Customers");

        //Syntax of creating List
        //List<ClassName> listName = new ArrayList<>();

        List<Customer> customers = jdbcUsingMethod.getAllCustomers();
        System.out.println("Customer Id | Customer Name | City | Email | Salesman Id");
        for(Customer customer : customers){
            System.out.println(customer.getCustomer_id() + " " +
                    customer.getCustomer_name() + " " +
                    customer.getCity() + " " +
                    customer.getEmail() + " " +
                    customer.getSalesman_id());
        }
    }
}