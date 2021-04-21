package com.jb.CouponSystem.repos;

import com.jb.CouponSystem.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompnyRepository extends JpaRepository<Company, Integer> {
    boolean findByNameAndEmail(String name,String email);
}
