package com.jonah.vttp5_paf_day01ws.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Customer {
    public int id;
    public String company;
    public String email;
    public String firstName;


    


    public Customer() {
    }
    
    public Customer(int id, String company, String email, String firstName) {
        this.id = id;
        this.company = company;
        this.email = email;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public static Customer toCustomer(SqlRowSet rs){
        Customer c = new Customer();
        c.setCompany(rs.getString("company"));
        c.setEmail(rs.getString("email_address"));
        c.setFirstName(rs.getString("first_name"));
        c.setId(rs.getInt("id"));
        return c;
    }


    


}
