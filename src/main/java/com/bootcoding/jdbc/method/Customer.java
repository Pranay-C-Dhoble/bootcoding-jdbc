package com.bootcoding.jdbc.method;
//this is a pojo class
//pojo class is a class which has only private variables and public getters and setters
//this class is used to store the data from the database
//And this class is used to send the data to the database
//full-form of pojo is plain old java object

//Data is stored in the form of objects in java
//so we need to create a class to store the data
public class Customer {
    private int  customer_id;
    private String customer_name;
    private String city;
    private String email;
    private int salesman_id;

    public int getCustomer_id() {//getCustomer_id() is a getter method
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {//setCustomer_id() is a setter method
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(int salesman_id) {
        this.salesman_id = salesman_id;
    }

}
