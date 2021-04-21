package com.jb.CouponSystem.repos;


import com.jb.CouponSystem.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean findByFirstNameAndEmail(String name, String email);
}
