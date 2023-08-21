package com.bootcoding.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteJdbcExample {
    public static void main(String[] args) {

        try{
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database Connection Object
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bootcoding",
                    "postgres", "Pranay@123");

            // 3. Query Database using Statement Object
            Statement stmt = conn.createStatement();
            String sql = "DELETE from customer where customer_id = 2000";
            // 4. Execute Query and Get ResultSet
            int i = stmt.executeUpdate(sql);
            // 4.1 Extract Result
            System.out.println("No of rows deleted = " + i);

            // 5.Connection CLose;
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
