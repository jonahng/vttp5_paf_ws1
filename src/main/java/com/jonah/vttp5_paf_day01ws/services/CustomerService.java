package com.jonah.vttp5_paf_day01ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jonah.vttp5_paf_day01ws.models.Customer;
import com.jonah.vttp5_paf_day01ws.models.Order;
import com.jonah.vttp5_paf_day01ws.repositories.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getAllCustomers(){
        return customerRepo.allCustomers();
    }

    public Customer getCustomerWithId(String customerId){
        return customerRepo.getCustomerFromId(customerId);
    }

    public List<Customer> getAllCustomersLimitOffset(String limit,String offset){
        return customerRepo.allCustomersLimitOffset(limit, offset);
    }

    public List<Order> getAllOrders(int customer_id){
        return customerRepo.allOrdersFromCustomerId(customer_id);
    }
}
