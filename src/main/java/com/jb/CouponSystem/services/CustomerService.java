package com.jb.CouponSystem.services;


import com.jb.CouponSystem.beans.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Boolean isCustomerExsit(String email, String password);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerID);

    Customer getOneCustomer(int customerID);

    List<Customer> getAllCustomers();
}
