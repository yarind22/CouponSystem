package com.jb.CouponSystem.facad;

import com.jb.CouponSystem.beans.Company;
import com.jb.CouponSystem.beans.Customer;
import com.jb.CouponSystem.exrptions.exeption;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminFacade extends ClientFacade {

    @Override
    public boolean login(String email, String password) {
        return email.equals("admin@admin.com") && password.equals("admin");
    }

    public void addCompany(Company company) throws exeption {
        for (Company company1 : compnyRepository.findAll()) {
            if (company.getName().equals(company1.getName()) || company.getEmail().equals(company1.getEmail())) {
                throw new exeption("sorry the name or email used");
            }
        }
            compnyRepository.save(company);

    }

    public void updateCompany(Company company) throws exeption {
        if (!company.getName().equals(compnyRepository.getOne(company.getId()).getName()) || !company.getPassword().equals(compnyRepository.getOne(company.getId()).getPassword())) {
            throw new exeption("sorry you canot change name or password.");
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

    public void addCustomr(Customer customer) throws exeption {
//        if (customer.getEmail() != customerRepository.getOne(customer.getId()).getEmail()) {
//            throw new exeption("sorry email is alredy used");
//        }
       customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) throws exeption {
        for (Customer cust : customerRepository.findAll()) {
            if (cust.getId() == customer.getId()) {
                customerRepository.saveAndFlush(customer);
                return;
            }
        }
        throw new exeption("sorry canot update ID");
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
