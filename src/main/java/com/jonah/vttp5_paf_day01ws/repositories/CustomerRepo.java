package com.jonah.vttp5_paf_day01ws.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.jonah.vttp5_paf_day01ws.models.Customer;
import com.jonah.vttp5_paf_day01ws.models.Order;

@Repository
public class CustomerRepo {
    @Autowired
    private JdbcTemplate template;


    public List<Customer> allCustomers(){
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_ALL_CUSTOMERS);
        List<Customer> allCustomers = new ArrayList<>();

        while (rs.next()) {
            Customer c = Customer.toCustomer(rs);
            allCustomers.add(c);
        }
        return allCustomers;
    }

    public Customer getCustomerFromId(String customerId){
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_GET_CUSTOMER_WITH_ID, customerId);

        Customer c = new Customer();
        while(rs.next()){
            c = Customer.toCustomer(rs);
        }
        return c;

    }

    public List<Customer> allCustomersLimitOffset(String limit, String offset){
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_ALL_CUSTOMERS_LIMIT_OFFSET,Integer.parseInt(limit), Integer.parseInt(offset));
        List<Customer> allCustomers = new ArrayList<>();

        while (rs.next()) {
            Customer c = Customer.toCustomer(rs);
            allCustomers.add(c);
        }
        return allCustomers;
    }

    public List<Order> allOrdersFromCustomerId(int customer_id){
        SqlRowSet rs = template.queryForRowSet(Queries.SQL_ORDERS_FROM_CUSTOMER_ID, customer_id);
        List<Order> allOrders = new ArrayList<>();

        while (rs.next()) {
            allOrders.add(Order.toOrder(rs));
        }
        return allOrders;
    }
    
}
