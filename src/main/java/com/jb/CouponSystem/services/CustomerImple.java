package com.jb.CouponSystem.services;

import com.jb.CouponSystem.beans.Customer;
import com.jb.CouponSystem.repos.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerImple implements CustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public Boolean isCustomerExsit(String email, String password) {
        return (customerRepository.findByEmailAndPassword(email, password)) != null;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerID) {
        customerRepository.deleteById(customerID);
    }

    @Override
    public Customer getOneCustomer(int customerID) {
        return customerRepository.getOne(customerID);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
