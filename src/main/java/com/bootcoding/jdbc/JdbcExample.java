package com.bootcoding.jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] arg){
        try{
            fetchAllRecords();
            getTotalCount();
            getRecordsBy("Ramesh");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //throws keyword is used to declare an exception.
    // It gives an information to the programmer that there may occur an exception, it is better for the programmer
    // to provide the exception handling code so that normal flow can be maintained.
    private static void getTotalCount() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcoding", "postgres", "Pranay@123");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM customer");

        if(resultSet.next()){
            int count = resultSet.getInt("count");
            System.out.println("Total Records in APP_CUSTOMER is " + count);
        }
        connection.close();
    }

    private static void fetchAllRecords() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcoding", "postgres", "Pranay@123");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

        while(resultSet.next()){
            int customerId = resultSet.getInt("customer_id");
            String name = resultSet.getString("cust_name");
            String city = resultSet.getString("city");
            String email = resultSet.getString("email");
            int salesManId = resultSet.getInt("salesman_id");
            System.out.println("Id = " + customerId);
            System.out.println("Customer Name = " + name);
            System.out.println("City = "+ city);
            System.out.println("Email Id = " + email);
            System.out.println("Salesman Id = " + salesManId);
        }
        connection.close();
    }


    private static void getRecordsBy(String name) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcoding", "postgres", "Pranay@123");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM customer WHERE cust_name = '"+name+"'");

        if(resultSet.next()){//next() method is used to move the cursor to the one row next from the current position
            int count = resultSet.getInt("count");
            System.out.println("Total Records in CUSTOMER is " + count);
        }
        connection.close();
    }
}
