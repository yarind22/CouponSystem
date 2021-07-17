package com.jb.CouponSystem.facade;

import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.beans.Customer;
import com.jb.CouponSystem.exceptions.GenericExceptions;
import com.jb.CouponSystem.exceptions.MyException;
import com.jb.CouponSystem.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AdminFacade extends ClientFacade {
    private final TokenManager tokenManager;

    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    public void addCompany(Company company,String token) throws MyException {
        if(!tokenManager.isExist(token)){
            throw new MyException(GenericExceptions.INVALID_TOKEN.getDescription());
        }
        for (Company company1 : compnyRepository.findAll()) {
            if (company.getName().equals(company1.getName()) || company.getEmail().equals(company1.getEmail())) {
                throw new MyException(GenericExceptions.ALREADY_USED.getDescription());
            }
        }
        tokenManager.updateTokenTime(token);
        compnyRepository.save(company);

    }

    public void updateCompany(Company company) throws MyException {
        if (!company.getName().equals(compnyRepository.getOne(company.getId()).getName()) || !company.getPassword().equals(compnyRepository.getOne(company.getId()).getPassword())) {
            throw new MyException(GenericExceptions.INVALID_OPERATION.getDescription());
        }
        compnyRepository.saveAndFlush(company);
    }


    public void deleteCompany(int companyID) {
        compnyRepository.deleteById(companyID);
    }

    public List<Company> getAllCompany() {
        return compnyRepository.findAll();
    }

    public void getOneCompany(int companyID) {
        System.out.println(compnyRepository.getOne(companyID));
    }

    public void addCustomr(Customer customer) throws MyException {
//        if (customer.getEmail() != customerRepository.getOne(customer.getId()).getEmail()) {
//            throw new exeption("sorry email is alredy used");
//        }
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) throws MyException {
        for (Customer cust : customerRepository.findAll()) {
            if (cust.getId() == customer.getId()) {
                customerRepository.saveAndFlush(customer);
                return;
            }
        }
        throw new MyException(GenericExceptions.INVALID_OPERATION.getDescription());
    }

    public void deleteCustomer(int customrID) {
        customerRepository.deleteById(customrID);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getOneCustomer(int customerID) {
        return customerRepository.getOne(customerID);
    }

}
