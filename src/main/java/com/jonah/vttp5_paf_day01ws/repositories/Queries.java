package com.jonah.vttp5_paf_day01ws.repositories;

public class Queries {

    public static final String SQL_ALL_CUSTOMERS = """
            select * from customers;
            """;

    public static final String SQL_GET_CUSTOMER_WITH_ID = """
            select * from customers where id = ?;
            """;

    public static final String SQL_ALL_CUSTOMERS_LIMIT_OFFSET = """
            select * from customers
            limit ? offset ?;
            """;

    public static final String SQL_ORDERS_FROM_CUSTOMER_ID = """
            select * from orders where customer_id = ?;
            """;
    
}
