package com.jonah.vttp5_paf_day01ws.models;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {
    public int employee_id;
    public int customer_id;
    public int shipper_id;
    public String order_date;






    


    public Order() {
    }

    
    public Order(int employee_id, int customer_id, int shipper_id, String order_date) {
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.shipper_id = shipper_id;
        this.order_date = order_date;
    }


    public int getEmployee_id() {
        return employee_id;
    }
    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
    public int getShipper_id() {
        return shipper_id;
    }
    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }
    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public static Order toOrder(SqlRowSet rs){
        Order o = new Order();
        o.setCustomer_id(rs.getInt("customer_id"));
        o.setEmployee_id(rs.getInt("employee_id"));
        o.setShipper_id(rs.getInt("shipper_id"));
        o.setOrder_date(rs.getString("order_date").toString());
        return o;
    }



    
    
}
