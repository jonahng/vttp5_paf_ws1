package com.jonah.vttp5_paf_day01ws.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jonah.vttp5_paf_day01ws.models.Customer;
import com.jonah.vttp5_paf_day01ws.models.Order;
import com.jonah.vttp5_paf_day01ws.services.CustomerService;

@RestController
@RequestMapping("/api")
public class NorthwindRestController {
    @Autowired
    CustomerService customerService;

    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers( @RequestParam(defaultValue = "5") String limit,@RequestParam(defaultValue = "0") String offset){
        List<Customer> allCustomers = customerService.getAllCustomersLimitOffset(limit,offset);
        return ResponseEntity.ok().body(allCustomers);
        
    }


    @GetMapping("/customer/{customer_id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customer_id") String customerId){
        Customer c = customerService.getCustomerWithId(customerId);

        if(c.getId()<1){
            return ResponseEntity.badRequest().body(c);

        }
        return ResponseEntity.ok().body(c);
        
    }

    @GetMapping("/customer/{customer_id}/orders")
    public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable("customer_id") int customer_id){
        List<Order> allOrders = new ArrayList<>();
        
        allOrders = customerService.getAllOrders(customer_id);
        return ResponseEntity.ok().body(allOrders);

    }
    
}
