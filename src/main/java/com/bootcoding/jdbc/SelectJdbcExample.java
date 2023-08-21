package com.bootcoding.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SelectJDBCExample {
    public static void main(String[] args) {

        try{//try is a block of code that is used to test a block of code for errors
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database Connection Object
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcoding",
                    "postgres", "Pranay@123");

            // 3. Query Database using Statement Object
            Statement stmt = conn.createStatement();

            // 4. Execute Query and Get ResultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            // 4.1 Extract Result

            while(rs.next()){

                // Single Row
                int customerId = rs.getInt("customer_id");
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString("email");
                int salesManId = rs.getInt("salesman_id");

                System.out.println("Id = " + customerId);
                System.out.println("Name = " + name);
                System.out.println("City = " + city);
                System.out.println("Email = " + email);
                System.out.println("SalesMan Id = " + salesManId);
            }

            // 5.Connection CLose;
            conn.close();
        }catch (Exception ex){//catch is a block of code that is used to handle an exception
            ex.printStackTrace();//printStackTrace() method in Java is a tool used to handle exceptions and errors
        }
    }

}
//try - catch block is used to handle the exceptions that might occur in the code.
//The try block contains the code that might throw an exception and the catch block handles those exceptions.
//The try block cannot be used alone. It must be followed by either catch or finally block.

//Exception is the parent class of all the exceptions that might occur in the code.
//return type of exception is string
//printStackTrace() method in Java is a tool used to handle exceptions and errors.



//The try block contains the code that might throw an exception and the catch block handles those exceptions.



